package ssucar.feedback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FeedbackDto {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class bio {
        private Float monthlyMileage;
        private Float totalMileage;
        private String latestDeparture;
        private String latestArrival;
    }



}
