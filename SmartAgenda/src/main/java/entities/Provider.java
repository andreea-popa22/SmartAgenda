package entities;

import lombok.Data;

@Data
public class Provider {
    private String name;
    private String phone;
    private String email;
    private Integer age;
    private Gender gender;
    private Location workLocation;
}
