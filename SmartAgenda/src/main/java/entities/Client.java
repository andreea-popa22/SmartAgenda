package entities;

import lombok.Data;

@Data
public class Client {
    private String name;
    private String phone;
    private String email;
    private Integer age;
    private Gender gender;
}
