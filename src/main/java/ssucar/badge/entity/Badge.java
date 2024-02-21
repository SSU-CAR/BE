package ssucar.badge.entity;

import jakarta.persistence.*;
import lombok.*;
import ssucar.driving.entity.Report;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="badge")
@Entity
public class Badge {
    @Id
    private int badgeId;

    private int status;
    private String name;
    private String caption;
    private int goal;
    private int number;

    public void increaseNumber() {
        this.number++;
        if(this.number == this.goal)
            status = 1;
    }
}