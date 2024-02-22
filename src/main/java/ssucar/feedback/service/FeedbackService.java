package ssucar.feedback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.dto.SummaryDto;
import ssucar.driving.entity.Report;
import ssucar.driving.entity.Summary;
import ssucar.driving.repository.ReportRepository;
import ssucar.driving.repository.SummaryRepository;
import ssucar.driving.service.DrivingService;
import ssucar.exception.BusinessLogicException;
import ssucar.exception.ExceptionCode;
import ssucar.feedback.dto.FeedbackDto;
import ssucar.scenario.entity.Scenario;
import ssucar.scenario.repository.ScenarioRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackService {
    @Autowired
    private final DrivingService drivingService;

    @Autowired
    private final ReportRepository reportRepository;

    @Autowired
    private final SummaryRepository summaryRepository;

    @Autowired
    private final ScenarioRepository scenarioRepository;

    public FeedbackDto.bioResponse makeBio(int thisMonth) {
        int reportItems = drivingService.reportItems();
        Optional<Report> optionalReport = reportRepository.findById(reportItems);
        Report latestReport =
                optionalReport.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.REPORT_NOT_FOUND));
        String latestDeparture = latestReport.getDeparturedAt();
        String latestArrival = latestReport.getArrivedAt();

        List<Report> allReports = reportRepository.findAll();
        float monthlyMileage = 0;
        float totalMileage = 0;

        for (Report report : allReports) {
            String departuredAt = report.getDeparturedAt();
            int month = extractMonth(departuredAt);
            // 월별 마일리지 계산
            if (month == thisMonth) {
                monthlyMileage += report.getMileage();
            }
            // 총 마일리지 계산
            totalMileage += report.getMileage();
        }

        return FeedbackDto.bioResponse.builder()
                .monthlyMileage(monthlyMileage)
                .totalMileage(totalMileage)
                .latestDeparture(latestDeparture)
                .latestArrival(latestArrival)
                .build();
    }

    public FeedbackDto.scoreResponse getAverage(int thisMonth) {
        List<Report> allReports = reportRepository.findAll();
        int scoreSum = 0;
        int thisMonthReport = 0;
        for (Report report : allReports) {
            int month = extractMonth(report.getDeparturedAt());
            if (month == thisMonth) {
                scoreSum += report.getScore();
                thisMonthReport++;
            }
        }
        int averageScore = scoreSum / thisMonthReport;

        return FeedbackDto.scoreResponse.builder()
                .averageScore(averageScore)
                .build();
    }

    public FeedbackDto.topRisksResponse getTopFourRisks(int thisMonth) {
        List<Integer> reportIdsThisMonth = reportRepository.findAll().stream()
                .filter(report -> extractMonth(report.getDeparturedAt()) == thisMonth)
                .map(Report::getReportId)
                .toList();
        Map<Integer, Integer> summaryCountMap = new HashMap<>();
        for (Integer reportId : reportIdsThisMonth) {
            List<Summary> summaries = summaryRepository.findByReport_ReportId(reportId);
            for (Summary summary : summaries) {
                int scenarioType = summary.getScenarioType();
                int summaryCount = summary.getSummaryCount();
                summaryCountMap.put(scenarioType, summaryCountMap.getOrDefault(scenarioType, 0) + summaryCount);
            }
        }

        List<SummaryDto> topRisks = summaryCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(4)
                .map(entry -> {
                    Optional<Scenario> optionalScenario = scenarioRepository.findById(entry.getKey());
                    Scenario scenario = optionalScenario.orElseThrow(() -> new BusinessLogicException(ExceptionCode.SCENARIO_NOT_FOUND));
                    return SummaryDto.builder()
                            .scenarioType(entry.getKey())
                            .scenarioName(scenario.getName()) // scenarioName 추가
                            .scenarioCount(entry.getValue())
                            .build();
                })
                .toList();

        return FeedbackDto.topRisksResponse.builder()
                .topRisks(topRisks)
                .build();
    }

    public FeedbackDto.cautionResponse getInternalExternalCautions(int thisMonth) {
        List<Integer> reportIdsThisMonth = reportRepository.findAll().stream()
                .filter(report -> extractMonth(report.getDeparturedAt()) == thisMonth)
                .map(Report::getReportId)
                .toList();

        Map<Integer, Integer> summaryCountMap = new HashMap<>();
        for (Integer reportId : reportIdsThisMonth) {
            List<Summary> summaries = summaryRepository.findByReport_ReportId(reportId);
            for (Summary summary : summaries) {
                int scenarioType = summary.getScenarioType();
                int summaryCount = summary.getSummaryCount();
                summaryCountMap.put(scenarioType, summaryCountMap.getOrDefault(scenarioType, 0) + summaryCount);
            }
        }

        List<SummaryDto> internalSummaries = summaryCountMap.entrySet().stream()
                .filter(entry -> entry.getKey() >= 1 && entry.getKey() <= 50)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> {
                    Optional<Scenario> optionalScenario = scenarioRepository.findById(entry.getKey());
                    Scenario scenario = optionalScenario.orElseThrow(() -> new BusinessLogicException(ExceptionCode.SCENARIO_NOT_FOUND));
                    return SummaryDto.builder()
                            .scenarioType(entry.getKey())
                            .scenarioName(scenario.getName()) // scenarioName 추가
                            .scenarioCount(entry.getValue())
                            .build();
                })
                .toList();

        List<SummaryDto> externalSummaries = summaryCountMap.entrySet().stream()
                .filter(entry -> entry.getKey() >= 51 && entry.getKey() < 100)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(2)
                .map(entry -> {
                    Optional<Scenario> optionalScenario = scenarioRepository.findById(entry.getKey());
                    Scenario scenario = optionalScenario.orElseThrow(() -> new BusinessLogicException(ExceptionCode.SCENARIO_NOT_FOUND));
                    return SummaryDto.builder()
                            .scenarioType(entry.getKey())
                            .scenarioName(scenario.getName()) // scenarioName 추가
                            .scenarioCount(entry.getValue())
                            .build();
                })
                .toList();

        return FeedbackDto.cautionResponse.builder()
                .internalSummaries(internalSummaries)
                .externalSummaries(externalSummaries)
                .build();





//        int reportItems = drivingService.reportItems();
//        List<Summary> allSummaries = summaryRepository.findByReport_ReportId(reportItems);
//        Map<Integer, Integer> summaryCountMap = new HashMap<>();
//
//        for (Summary summary : allSummaries) {
//            String departuredAt = summary.getReport().getDeparturedAt();
//            int month = extractMonth(departuredAt);
//            if (month == thisMonth) {
//                int scenarioType = summary.getScenarioType();
//                int summaryCount = summary.getSummaryCount();
//                summaryCountMap.put(scenarioType, summaryCountMap.getOrDefault(scenarioType, 0) + summaryCount);
//            }
//        }
//
//
//        List<SummaryDto> internalSummaries = summaryCountMap.entrySet().stream()
//                .filter(entry -> entry.getKey() >= 1 && entry.getKey() <= 50)
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .limit(3)
//                .map(entry -> {
//                    Optional<Scenario> optionalScenario = scenarioRepository.findById(entry.getKey());
//                    Scenario scenario = optionalScenario.orElseThrow(() -> new BusinessLogicException(ExceptionCode.SCENARIO_NOT_FOUND));
//                    return SummaryDto.builder()
//                            .scenarioType(entry.getKey())
//                            .scenarioName(scenario.getName()) // scenarioName 추가
//                            .scenarioCount(entry.getValue())
//                            .build();
//                })
//                .toList();
//
//        List<SummaryDto> externalSummaries = summaryCountMap.entrySet().stream()
//                .filter(entry -> entry.getKey() >= 51 && entry.getKey() < 100)
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .limit(2)
//                .map(entry -> {
//                    Optional<Scenario> optionalScenario = scenarioRepository.findById(entry.getKey());
//                    Scenario scenario = optionalScenario.orElseThrow(() -> new BusinessLogicException(ExceptionCode.SCENARIO_NOT_FOUND));
//                    return SummaryDto.builder()
//                            .scenarioType(entry.getKey())
//                            .scenarioName(scenario.getName()) // scenarioName 추가
//                            .scenarioCount(entry.getValue())
//                            .build();
//                })
//                .toList();
//
//        return FeedbackDto.cautionResponse.builder()
//                .internalSummaries(internalSummaries)
//                .externalSummaries(externalSummaries)
//                .build();
    }

    private int extractMonth(String departuredAt) {
        String[] tokens = departuredAt.split("-");
        if (tokens.length >= 2) {
            return Integer.parseInt(tokens[1]);
        }
        return -1;
    }

}
