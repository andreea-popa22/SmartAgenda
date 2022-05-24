package smartagenda.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smartagenda.domain.embeddable.TimeslotId;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TimeSlot {
    @AttributeOverride(name="id", column = @Column(name="timeslotId"))
    @EmbeddedId TimeslotId timeslotId;

    @MapsId("personPK")
    @ManyToOne Person person;
    private int startHourId;
    private int endHourId;

    @ManyToMany
    @JoinTable(
            name = "timeslot_to_schedule",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "timeslot_id"))
    Set<Schedule> schedules;
}
