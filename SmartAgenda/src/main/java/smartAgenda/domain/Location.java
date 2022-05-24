package smartagenda.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Data
@NoArgsConstructor
@Entity
public class Location {
    @Id
    private int locationId;
    private String name;
    private String address;
    private String contact;

    @OneToMany(targetEntity=smartagenda.domain.Appointment.class, cascade=ALL,
            mappedBy="appointment_id")
    Set<Appointment> appointments;

    @Builder
    public Location(int locationId, String name, String address, String contact) {
        this.locationId = locationId;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
}
