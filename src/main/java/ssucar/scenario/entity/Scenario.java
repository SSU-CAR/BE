package ssucar.scenario.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;


@Getter
@Entity
@Table(name="Scenario")
@Builder
public class Scenario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scenarioId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "WEIGHT", nullable = false)
    private int weight;

    @Builder.Default
    @Column(name = "TOTAL", nullable = false)
    private long total = 0;

}
