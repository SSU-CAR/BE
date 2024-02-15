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


    @Column(nullable = false)
    private Integer scenarioType;

    @Column(nullable = false)
    private LocalDateTime createdAt;


}
