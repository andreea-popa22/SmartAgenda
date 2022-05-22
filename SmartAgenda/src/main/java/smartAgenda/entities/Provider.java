package smartagenda.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import smartagenda.entitiesHelpers.Gender;

@Getter
@Setter
public class Provider extends Person{
    private int id;
    private int experience;

    @Builder
    public Provider(int id, int experience, String name, String phone, String email, Integer age, Gender gender)
    {
        this.id = id;
        this.experience = experience;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.schedule = new Schedule();
    }

    @Override
    public String getDescription() {
        return String.format("Provider %s", name);
    }

}
