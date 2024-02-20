package ssucar.history.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssucar.driving.dto.SummaryDto;

import java.util.List;

public class HistoryDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class allReportResponse {
        private Integer reportId;
        private String departuredAt;
        private String arrivedAt;
        private float mileage;
        private int score;

    }


}
