package smartagenda.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
public abstract class Person {
    @Id
    protected int personId;
    protected String name;
    protected String phone;
    protected String email;
    protected Integer age;
    protected Gender gender;
    protected int scheduleId;

    public abstract String getDescription();
}
