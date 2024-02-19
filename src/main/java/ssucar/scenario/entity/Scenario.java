package ssucar.scenario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="scenario")
@Builder
@Entity
public class Scenario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    private int scenarioId;

    private String name;
    private int weight;
    private long total;

}
