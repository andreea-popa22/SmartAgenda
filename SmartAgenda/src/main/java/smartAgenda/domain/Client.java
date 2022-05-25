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
@DiscriminatorValue("1")
public class Client extends Person{

    @OneToMany
    @JoinColumn(name = "person_id")
    private List<Appointment> appointments;

    @Builder
    public Client(int personId, String name, Integer age, String email, String phone, Gender gender)
    {
        this.personId = personId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        //this.schedule = new Schedule();
    }

    @Override
    public String getDescription() {
        return String.format("Client %s", name);
    }

    @Override
    public String toString() {
        return "Client{" +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
