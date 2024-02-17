package ssucar.driving.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.entity.Report;
//import ssucar.driving.repository.RecordRepository;
import ssucar.driving.repository.ReportRepository;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class DrivingService {

    private boolean isDriving = false;
    private int reportItems = 0;

    @Autowired
    private final ReportRepository reportRepository;
//    private final RecordRepository recordRepository;


    public DrivingDto.startResponse startDriving() {
        if (!isDriving) {
            LocalDateTime currentTime = LocalDateTime.now();
            Report newReport = Report.builder()
                    .departuredAt(currentTime)
                    .arrivedAt(currentTime)
                    .mileage(0f)
                    .build();
            Report savedReport = reportRepository.save(newReport);
            reportItems = savedReport.getReportId();

            return new DrivingDto.startResponse(1);
        } else {
            return new DrivingDto.startResponse(0);
        }
    }


}
