package ssucar.driving.dto;

import lombok.*;

import java.util.List;

public class DrivingDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class startResponse {
        private Integer reportId;

        public startResponse(int reportId) {
            this.reportId = reportId;
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class endResponse {
        private Integer reportId;

        public endResponse(int reportId) {
            this.reportId = reportId;
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class getReportResponse {
        private Integer reportId;
        private String departuredAt;
        private String arrivedAt;
        private float mileage;
        private int score;
        private String scoreComment;
        private List<SummaryDto> internalSummaries;
        private List<SummaryDto> externalSummaries;

    }

}
