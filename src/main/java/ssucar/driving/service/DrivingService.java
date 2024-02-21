package ssucar.driving.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssucar.badge.entity.Badge;
import ssucar.badge.service.BadgeService;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.dto.SummaryDto;
import ssucar.driving.entity.Report;
import ssucar.driving.entity.Risk;
import ssucar.driving.entity.Summary;
import ssucar.driving.repository.RiskRepository;
import ssucar.driving.repository.ReportRepository;
import ssucar.driving.repository.SummaryRepository;
import ssucar.exception.BusinessLogicException;
import ssucar.exception.ExceptionCode;
import ssucar.scenario.entity.Scenario;
import ssucar.scenario.repository.ScenarioRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DrivingService {

    private boolean isDriving = false;
    private int reportItems = 0;

    @Autowired
    private final ReportRepository reportRepository;

    @Autowired
    private final RiskRepository riskRepository;

    @Autowired
    private final SummaryRepository summaryRepository;

    @Autowired
    private final ScenarioRepository scenarioRepository;

    @Autowired
    private final BadgeService badgeService;

    public DrivingDto.startResponse startDriving() {
        if (!isDriving) {
            setDriving(true);
            LocalDateTime currentTime = LocalDateTime.now();
            String parsedCurrentTime = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Report newReport = Report.builder()
                    .departuredAt(parsedCurrentTime)
                    .arrivedAt(parsedCurrentTime)
                    .mileage(0f)
                    .build();
            Report savedReport = reportRepository.save(newReport);
            reportItems = savedReport.getReportId();

            return new DrivingDto.startResponse(reportItems);
        } else {
            return new DrivingDto.startResponse(0);
        }
    }

    public Risk createRisk(int type, String createdAt) {
        //risk 저장
        Report findReport = findReport(reportItems);
        System.out.println("reportId: " + findReport.getReportId());

        Risk postRisk = Risk.builder()
                .scenarioType(type)
                .createdAt(createdAt)
                .report(findReport)
                .build();

        findReport.getRisks().add(postRisk);
        return riskRepository.save(postRisk);
    }


    public Summary updateSummary(int scenarioType) {
        Report findReport = findReport(reportItems);
        Summary findSummary = summaryRepository.findByReport_ReportIdAndScenarioType(findReport.getReportId(), scenarioType);

        if (findSummary != null) {
            findSummary.increaseSummaryCount();
            //
            Optional<Scenario> optionalScenario = scenarioRepository.findById(scenarioType);
            Scenario fm = optionalScenario.orElseThrow(() -> new BusinessLogicException(ExceptionCode.SCENARIO_NOT_FOUND));
            fm.increaseTotal();
            //
            return summaryRepository.save(findSummary);
        } else {
            Optional<Scenario> optionalScenario = scenarioRepository.findById(scenarioType);
            Scenario fm = optionalScenario.orElseThrow(() -> new BusinessLogicException(ExceptionCode.SCENARIO_NOT_FOUND));
            fm.increaseTotal();

            Summary postSummary = Summary.builder()
                    .scenarioType(scenarioType)
                    .summaryCount(0)
                    .report(findReport)
                    .summaryCount(1)
                    .scenarioName(fm.getName())
                    .build();
            findReport.getSummaries().add(postSummary);
            return summaryRepository.save(postSummary);
        }
    }


    public void updateMileage(int type, String createdAt) {
        Report report = findReport(reportItems);
        Optional<Report> optionalReport = reportRepository.findById(report.getReportId());
        Report fm = optionalReport.orElseThrow(() -> new BusinessLogicException(ExceptionCode.REPORT_NOT_FOUND));
        fm.setMileage(Float.valueOf(createdAt));
        reportRepository.save(fm);
    }

    public DrivingDto.endResponse endDriving() {
        if (isDriving) {
            setDriving(false);
            Report report = findReport(reportItems);
            LocalDateTime currentTime = LocalDateTime.now();
            String parsedCurrentTime = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

//            이거 save말고 다시 생각
            Optional<Report> optionalReport = reportRepository.findById(report.getReportId());
            Report fm = optionalReport.orElseThrow(() -> new BusinessLogicException(ExceptionCode.REPORT_NOT_FOUND));
//            Optional.ofNullable(report.getMileage()).ifPresent(mileage -> fm.setMileageㅠㅁㅇㅎㄷ(report.getMileage()));

            //운전 점수 산정
            int score = 100; //기본 점수 100점
            List<Summary> list = summaryRepository.findByReport_ReportId(reportItems);
            for(Summary summary : list) { //위반 횟수 * 각각의 가중치만큼 감점
                int count = summary.getSummaryCount();
                Scenario scenario = scenarioRepository.findById(summary.getScenarioType()).orElseThrow(() -> new IllegalArgumentException(("해당 번호의 시나리오가 존재하지 않습니다.")));
                int weight = scenario.getWeight();
                score -= count * weight;
            }
            //주행거리가 많아질수록 이를 반영하기 위해 가점
            int mileage = report.getMileage().intValue();
            score += mileage/20;
            //100점이 넘어가면 100점으로 처리, 0점 미만이면 0점으로 처리
            if(score>100)
                score = 100;
            else if(score<0)
                score = 0;

            fm.setScore(score);
            report.setArrivedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            Report endedReport = reportRepository.save(fm);

            //Badge 관련 업데이트
            //Badge 1
            badgeService.updateBadge(1);
            //Badge 2
            if(endedReport.getScore()>=90)
                badgeService.updateBadge(2);
            //Badge 3
            if(endedReport.getScore()==100)
                badgeService.updateBadge(3);
            //Badge 4
            //주행(100km 이상)에서 문제 상황 10번 미만으로 받기
            //Badge 5
            //졸음 경고 없이 10번 주행
            //Badge 6
            List<Badge> badges = badgeService.getBadges();
            int chk = 0;
            for(Badge badge : badges) {
                if(badge.getStatus()==1)
                    chk++;
            }
            if(chk==5)
                badgeService.updateBadge(6);

            reportItems = endedReport.getReportId();
            return new DrivingDto.endResponse(reportItems);
        } else {
            return new DrivingDto.endResponse(0);
        }
    }


    public DrivingDto.getReportResponse getReport(Integer reportId) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);

        Report report =
                optionalReport.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.REPORT_NOT_FOUND));

        return DrivingDto.getReportResponse.builder()
                .reportId(report.getReportId())
                .departuredAt(report.getDeparturedAt())
                .arrivedAt(report.getArrivedAt())
                .mileage(report.getMileage())
                .score(report.getScore())
                .scoreComment("지난번보다 20점이나 올랐네요! 수고하셨습니다!")
                .internalSummaries(getInternalSummariesDto(report.getReportId()))
                .externalSummaries(getExternalSummariesDto(report.getReportId()))
                .build();
    }


    public boolean isDriving() {
        return isDriving;
    }

    public void setDriving(boolean driving) {
        isDriving = driving;
    }

    public int reportItems() {
        return reportItems;
    }

    //id로 report 찾기
    @Transactional(readOnly = true)
    public Report findReport(int reportId) {
        Optional<Report> optionalReport = reportRepository.findById(reportId);
        return optionalReport.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.REPORT_NOT_FOUND));
    }

    public List<SummaryDto> getInternalSummariesDto(int reportId) {
        return summaryRepository.findByReport_ReportId(reportId).stream()
                .filter(summary -> summary.getScenarioType() >= 1 && summary.getScenarioType() <= 50)
                .map(summary -> SummaryDto.builder()
                        .scenarioType(summary.getScenarioType())
                        .scenarioName(summary.getScenarioName())
                        .scenarioCount(summary.getSummaryCount())
                        .build())
                .collect(Collectors.toList());
    }

    public List<SummaryDto> getExternalSummariesDto(int reportId) {
        return summaryRepository.findByReport_ReportId(reportId).stream()
                .filter(summary -> summary.getScenarioType() >= 51 && summary.getScenarioType() < 100)
                .map(summary -> SummaryDto.builder()
                        .scenarioType(summary.getScenarioType())
                        .scenarioName(summary.getScenarioName())
                        .scenarioCount(summary.getSummaryCount())
                        .build())
                .collect(Collectors.toList());
    }

}
