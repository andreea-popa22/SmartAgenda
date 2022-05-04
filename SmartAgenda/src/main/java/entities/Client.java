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
    public Client(int clientId, String name, String phone, String email, Integer age, Gender gender)
    {
        this.clientId = clientId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.schedule = new Schedule();
    }
}
