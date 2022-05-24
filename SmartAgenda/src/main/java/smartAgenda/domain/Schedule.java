package smartagenda.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Schedule {
    @Id
    private int scheduleId;

    private Date date;

    @ManyToMany(mappedBy = "schedules")
    Set<TimeSlot> timeSlots;

    @ManyToOne
    @JoinColumn(name="personId", nullable=false)
    Person people;

}
