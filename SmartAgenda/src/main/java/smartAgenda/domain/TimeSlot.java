package smartagenda.domain;

import lombok.*;
import smartagenda.domain.embeddable.TimeslotId;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TimeSlot {
    @AttributeOverride(name="id", column = @Column(name="timeslot_id"))
    @EmbeddedId TimeslotId timeslotId;

    @MapsId("schedulePK")
    @ManyToOne
    Schedule schedule;
    private int startHourId;
    private int endHourId;

    @ManyToMany(cascade = CascadeType.ALL)
    //@JoinTable(
            //name = "timeslot_to_schedule",
            @JoinColumn(name = "timeslot_id", insertable = false, updatable = false)
            @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
    Set<Schedule> schedules;
}
