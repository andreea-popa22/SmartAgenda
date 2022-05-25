package smartagenda.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("2")
public class Provider extends Person{
    private int experience;

    @OneToMany
    @JoinColumn(name = "person_id")
    private List<Appointment> appointments;
    @Builder
    public Provider(int personId, int experience, String name, String phone, String email, Integer age, Gender gender)
    {
        this.personId = personId;
        this.experience = experience;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.gender = gender;
        //this.schedule = new Schedule();
    }

    @Override
    public String getDescription() {
        return String.format("Provider %s", name);
    }

}
