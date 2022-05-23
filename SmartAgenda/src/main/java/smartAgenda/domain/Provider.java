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
@DiscriminatorValue("Provider")
public class Provider extends Person{
    @Id
    private int providerId;
    private int experience;

    @Builder
    public Provider(int providerId, int experience, String name, String phone, String email, Integer age, Gender gender)
    {
        this.providerId = providerId;
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
