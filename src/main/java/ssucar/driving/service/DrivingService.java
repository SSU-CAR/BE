package ssucar.driving.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.entity.Report;
import ssucar.driving.entity.Risk;
import ssucar.driving.repository.RiskRepository;
import ssucar.driving.repository.ReportRepository;
import ssucar.exception.BusinessLogicException;
import ssucar.exception.ExceptionCode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private final RiskRepository recordRepository;


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

            return new DrivingDto.startResponse(1);
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
        return recordRepository.save(postRisk);
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

}
