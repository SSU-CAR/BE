package ssucar.driving.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Report")
@Builder
public class Report {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPORT_ID")
    @Getter
    private int reportId;

    @Column(name = "DEPARTURED_AT")
    private LocalDateTime departuredAt;
    @Column(name = "ARRIVED_AT")
    private LocalDateTime arrivedAt;
    @Column(name = "MILEAGE")
    private Float mileage;

//    @Builder.Default
//    @OneToMany(mappedBy = "report")
//    private List<Record> records = new ArrayList<>();

}
