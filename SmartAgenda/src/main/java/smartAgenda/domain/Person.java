package smartagenda.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor

public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "product_key_sequence_generator")
    @SequenceGenerator(name = "product_key_sequence_generator", sequenceName = "product_sequence", allocationSize = 1)
    protected int personId;
    protected String name;
    protected String phone;
    protected String email;
    protected Integer age;
    protected Gender gender;

    @OneToMany(targetEntity=smartagenda.domain.Schedule.class, cascade=ALL,
            mappedBy="schedule_id")
    Set<Schedule> timetable;
    public abstract String getDescription();
}
