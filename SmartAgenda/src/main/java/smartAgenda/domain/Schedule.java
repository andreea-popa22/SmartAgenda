package smartagenda.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "instructor_key_sequence_generator")
    @SequenceGenerator(name = "instructor_key_sequence_generator", sequenceName = "instructor_sequence", allocationSize = 1)
    private int scheduleId;

    private Date date;

    @ManyToMany(mappedBy = "schedules")
    Set<TimeSlot> timeSlots;

    @ManyToOne
    @JoinColumn(name="personId", nullable=false)
    Person people;

}
