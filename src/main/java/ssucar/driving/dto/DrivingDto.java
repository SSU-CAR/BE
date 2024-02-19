package ssucar.driving.dto;

import lombok.*;

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

}
