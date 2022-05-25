package smartagenda.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    private int appointmentId;
    private float duration;
    private Date date;
    private int hourId;

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private Client client;

    @ManyToOne
    @JoinColumn(name="person_id", nullable=false)
    private Provider provider;

    @ManyToOne
    @JoinColumn(name="location_id", nullable=false)
    private Location location;
    private ServiceType serviceType;
    private Integer price;

    @Builder
    public Appointment(int id, float duration, Date date, int hourId, Client client, Provider provider, Location location, ServiceType serviceType, Integer price) {
        this.appointmentId = id;
        this.duration = duration;
        this.date = date;
        this.hourId = hourId;
        this.client = client;
        this.provider = provider;
        this.location = location;
        this.serviceType = serviceType;
        this.price = price;
    }
}
