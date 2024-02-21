package ssucar.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssucar.driving.dto.SummaryDto;

import java.util.List;

public class FeedbackDto {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class bioResponse {
        private Float monthlyMileage;
        private Float totalMileage;
        private String latestDeparture;
        private String latestArrival;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class scoreResponse {
        private int averageScore;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class topRisksResponse {
        private List<SummaryDto> topRisks;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class cautionResponse {
        private List<SummaryDto> internalSummaries;
        private List<SummaryDto> externalSummaries;
    }


}
