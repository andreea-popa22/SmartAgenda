package smartagenda.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("1")
public class Client extends Person{

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
