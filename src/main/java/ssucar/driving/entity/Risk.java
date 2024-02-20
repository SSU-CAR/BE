package ssucar.driving.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name="risk")
@Entity
public class Risk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int riskId;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;

    private int scenarioType;
    private String createdAt;


}
