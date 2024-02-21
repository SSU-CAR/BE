package ssucar.home.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.entity.Report;
import ssucar.driving.repository.ReportRepository;
import ssucar.driving.service.DrivingService;
import ssucar.home.dto.HomeDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class HomeService {

    @Autowired
    private final DrivingService drivingService;

    @Autowired
    private final ReportRepository reportRepository;


    public HomeDto.scoreResponse getLatestScore() {
        int reportItems = drivingService.reportItems();
        Report latestReport = drivingService.findReport(reportItems);

        return new HomeDto.scoreResponse(latestReport.getScore());
    }
}
