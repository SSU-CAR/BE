package ssucar.driving.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="report")
@Builder
public class Report {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int reportId;

    private LocalDateTime departuredAt;
    private LocalDateTime arrivedAt;
    private Float mileage;

//    @Builder.Default
//    @OneToMany(mappedBy = "report")
//    private List<Record> records = new ArrayList<>();

}
