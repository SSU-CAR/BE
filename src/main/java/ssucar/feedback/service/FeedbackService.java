package ssucar.feedback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.entity.Report;
import ssucar.driving.repository.ReportRepository;
import ssucar.driving.service.DrivingService;
import ssucar.exception.BusinessLogicException;
import ssucar.exception.ExceptionCode;
import ssucar.feedback.dto.FeedbackDto;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackService {
    @Autowired
    private final DrivingService drivingService;

    @Autowired
    private final ReportRepository reportRepository;


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

    private int extractMonth(String departuredAt) {
        String[] tokens = departuredAt.split("-");
        if (tokens.length >= 2) {
            return Integer.parseInt(tokens[1]);
        }
        return -1;
    }

}
