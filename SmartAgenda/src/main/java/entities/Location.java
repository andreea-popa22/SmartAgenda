package entities;

import lombok.Builder;
import lombok.Data;

@Data
public class Location {
    private int id;
    private String name;
    private String address;
    private String contact;

    @Builder
    public Location(int id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
}
