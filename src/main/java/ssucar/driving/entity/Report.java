package ssucar.driving.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="report")
@Builder
public class Report {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int reportId;

    private String departuredAt;
    private String arrivedAt;
    private Float mileage;

    @Builder.Default
    @OneToMany(mappedBy = "report", cascade = CascadeType.PERSIST)
    private List<Risk> risks = new ArrayList<>();



}
