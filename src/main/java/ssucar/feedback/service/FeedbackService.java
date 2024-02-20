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

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackService {
    @Autowired
    private final DrivingService drivingService;

    @Autowired
    private final ReportRepository reportRepository;


//    public FeedbackDto.bio makeBio(){
//        int reportItems = drivingService.reportItems();
//
//        String latestDeparture = reportRepository.findById(reportItems).isPresent()get().getDeparturedAt();
//
//        Optional<Report> optionalReport = reportRepository.findById(reportId);
//
//        Report report =
//                optionalReport.orElseThrow(() ->
//                        new BusinessLogicException(ExceptionCode.REPORT_NOT_FOUND));
//
////        return FeedbackDto.bio.builder()
////                .monthlyMileage(report.getReportId())
////                .totalMileage(report.getDeparturedAt())
////                .latestDeparture(report.getArrivedAt())
////                .latestArrival(report.getMileage())
////                .build();
//    }

}
