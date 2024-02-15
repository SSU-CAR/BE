package ssucar.driving.entity;

import jakarta.persistence.*;
import lombok.Builder;
import java.time.LocalDateTime;



@Entity
@Table(name="Record")
@Builder
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordId;

    @ManyToOne
    @JoinColumn(name = "REPORT_ID")
    private Report report;

    @Column(name = "SCENARIO_TYPE", nullable = false)
    private Integer scenarioType;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;


}
