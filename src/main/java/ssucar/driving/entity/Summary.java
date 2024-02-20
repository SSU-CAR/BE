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
@Table(name="summary")
@Entity
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int summaryId;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;

    private int scenarioType;
    private int summaryCount;
    private String scenarioName;

    public void increaseSummaryCount() {
        this.summaryCount += 1;
    }


}
