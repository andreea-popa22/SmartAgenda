package smartagenda.entities;

import lombok.Data;
import lombok.Getter;
import smartagenda.entitiesHelpers.Gender;

@Getter
public abstract class Person {
    protected String name;
    protected String phone;
    protected String email;
    protected Integer age;
    protected Gender gender;
    protected Schedule schedule;

    public abstract String getDescription();
}
