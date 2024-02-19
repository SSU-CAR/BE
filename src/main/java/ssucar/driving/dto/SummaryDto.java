package ssucar.driving.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SummaryDto {
    //    @Positive
    private String scenarioName;
    private int scenarioCount;
}