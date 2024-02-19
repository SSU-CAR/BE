package ssucar.scenario.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;


@Getter
@Entity
@Table(name="scenario")
@Builder
public class Scenario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long scenarioId;

    private String name;
    private int weight;
    private long total;

}
