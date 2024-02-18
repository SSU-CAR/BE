//package ssucar.driving.entity;
//
//import jakarta.persistence.*;
//import lombok.Builder;
//import java.time.LocalDateTime;
//
//
//
//@Entity
//@Table(name="record")
//@Builder
//public class Record {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int recordId;
//
//    @ManyToOne
//    @JoinColumn(name = "report_id")
//    private Report report;
//
//    @Column
//    private Integer scenarioType;
//
//    @Column
//    private LocalDateTime createdAt;
//
//
//}
