package entities;

import entitiesHelpers.Gender;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Hashtable;

@Getter
@Setter
public class Client extends Person{
    private int clientId;

    @Builder
    public Client(int clientId, String name, Integer age, String email, String phone, Gender gender)
    {
        this.clientId = clientId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.schedule = new Schedule();
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
