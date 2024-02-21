package ssucar.home.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.dto.SummaryDto;
import ssucar.driving.entity.Report;
import ssucar.driving.entity.Summary;
import ssucar.driving.repository.ReportRepository;
import ssucar.driving.service.DrivingService;
import ssucar.exception.BusinessLogicException;
import ssucar.exception.ExceptionCode;
import ssucar.home.dto.HomeDto;
import ssucar.home.dto.ScoreDto;
import ssucar.scenario.entity.Scenario;
import ssucar.scenario.repository.ScenarioRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeService {

    @Autowired
    private final DrivingService drivingService;

    @Autowired
    private final ReportRepository reportRepository;

    @Autowired
    private final ScenarioRepository scenarioRepository;


    private String homeFeedback;


    public HomeDto.scoreResponse getLatestScore() {
        int reportItems = drivingService.reportItems();
        Report latestReport = drivingService.findReport(reportItems);

        return new HomeDto.scoreResponse(latestReport.getScore());
    }

    public HomeDto.scoresResponse getLatestScores() {
        List<ScoreDto> scores = reportRepository.findTop3ByOrderByReportIdDesc()
                .stream()
                .map(report -> new ScoreDto(report.getReportId(), report.getScore()))
                .collect(Collectors.toList());
        while (scores.size() < 3) {
            scores.add(new ScoreDto(0, 0));
        }

        scores.sort(Comparator.comparingInt(ScoreDto::getReportId));
        return new HomeDto.scoresResponse().builder().scores(scores).build();
    }

    public HomeDto.feedbackResponse getHomeFeedback() {
        homeFeedback = "차선 변경에 좀 더 신경써봅시다";
        return new HomeDto.feedbackResponse(homeFeedback);
    }

    public HomeDto.risksResponse getRisks() {
        List<Report> latestReports = reportRepository.findTop3ByOrderByReportIdDesc();

        // 각 Report에 대한 scenarioType별 summaryCount 합산
        Map<Integer, Integer> summaryCountMap = latestReports.stream()
                .flatMap(report -> report.getSummaries().stream())
                .collect(Collectors.groupingBy(Summary::getScenarioType,
                        Collectors.summingInt(Summary::getSummaryCount)));

        // 상위 3개 summaryCount 항목 추출
        List<SummaryDto> recentRisks = summaryCountMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(3)
                .map(entry -> {
                    Optional<Scenario> optionalScenario = scenarioRepository.findById(entry.getKey());
                    Scenario scenario = optionalScenario.orElseThrow(() -> new BusinessLogicException(ExceptionCode.SCENARIO_NOT_FOUND));
                    return SummaryDto.builder()
                            .scenarioType(entry.getKey())
                            .scenarioName(scenario.getName())
                            .scenarioCount(entry.getValue())
                            .build();
                })
                .collect(Collectors.toList());

        return HomeDto.risksResponse.builder()
                .recentRisks(recentRisks)
                .build();
    }
}
