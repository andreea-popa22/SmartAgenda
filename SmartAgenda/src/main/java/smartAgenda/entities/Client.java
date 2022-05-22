package smartagenda.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import smartagenda.entitiesHelpers.Gender;

@Getter
@Setter
public class Client extends Person{
    private int clientId;

    @Builder
    public Client(int clientId, String name, Integer age, String email, String phone, Gender gender)
    {
        this.clientId = clientId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.schedule = new Schedule();
    }

    @Override
    public String getDescription() {
        return String.format("Client %s", name);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
