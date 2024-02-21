package ssucar.home.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
