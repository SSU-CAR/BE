package ssucar.history.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssucar.driving.dto.DrivingDto;
import ssucar.driving.entity.Report;
import ssucar.driving.repository.ReportRepository;
import ssucar.driving.repository.RiskRepository;
import ssucar.driving.service.DrivingService;
import ssucar.exception.BusinessLogicException;
import ssucar.exception.ExceptionCode;
import ssucar.history.dto.HistoryDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class HistoryService {
    @Autowired
    private final DrivingService drivingService;
    @Autowired
    private final ReportRepository reportRepository;

    public List<HistoryDto.allReportResponse> findHistories() {
        List<HistoryDto.allReportResponse> list = new ArrayList<>();
        int reportItems = drivingService.reportItems();
        for(int i=1; i <= reportItems; i++){
            Optional<Report> optionalReport = reportRepository.findById(i);

            Report report =
                    optionalReport.orElseThrow(() ->
                            new BusinessLogicException(ExceptionCode.REPORT_NOT_FOUND));

            list.add(HistoryDto.allReportResponse.builder()
                    .reportId(report.getReportId())
                    .departuredAt(report.getDeparturedAt())
                    .arrivedAt(report.getArrivedAt())
                    .mileage(report.getMileage())
                    .score(report.getScore())
                    .build()
            );
        }
        return list;
    }
}
