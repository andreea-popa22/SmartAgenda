package entities;

import entitiesHelpers.Gender;
import lombok.Getter;

@Getter
public abstract class Person {
    protected String name;
    protected String phone;
    protected String email;
    protected Integer age;
    protected Gender gender;
    protected Schedule schedule;
}
