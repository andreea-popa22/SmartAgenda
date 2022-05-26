package smartagenda.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import smartagenda.domain.embeddable.ScheduleId;

import javax.persistence.*;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Schedule {
    @AttributeOverride(name="id", column = @Column(name="scheduleId"))
    @EmbeddedId ScheduleId scheduleId;

    @MapsId("personPK")
    @ManyToOne
    Person person;
    private Date date;

    @OneToMany(mappedBy = "schedule")
    private List<TimeSlot> timeSlots;

//    @ManyToOne
//    @JoinColumn(name="person_id", nullable=false, insertable = false, updatable = false)
//    Person person;

}
