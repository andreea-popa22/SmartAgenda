package smartagenda.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Location {
    @Id
    private int locationId;
    private String name;
    private String address;
    private String contact;

    @Builder
    public Location(int locationId, String name, String address, String contact) {
        this.locationId = locationId;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
}
