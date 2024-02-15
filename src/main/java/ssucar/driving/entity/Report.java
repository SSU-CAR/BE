package ssucar.driving.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;


@Entity
@Table(name="Report")
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    @Column(nullable = false)
    private LocalDateTime departuredAt;

    private LocalDateTime arrivedAt;

    @Column(nullable = false)
    private Float mileage = 0.0f;

}
