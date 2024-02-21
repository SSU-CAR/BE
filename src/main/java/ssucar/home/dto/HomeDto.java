package ssucar.home.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssucar.driving.dto.SummaryDto;

import java.util.List;

public class HomeDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class scoreResponse {
        private Integer score;

        public scoreResponse(int score) {
            this.score = score;
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class scoresResponse {
        private List<ScoreDto> scores;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class feedbackResponse {
        private String feedback;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class risksResponse {
        private List<SummaryDto> recentRisks;
    }
}
