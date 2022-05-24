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
    private int clientId;
    private int providerId;

    @ManyToOne
    @JoinColumn(name="locationId", nullable=false)
    private Location location;
    private ServiceType serviceType;
    private Integer price;

    @Builder
    public Appointment(int id, float duration, Date date, int hourId, int clientId, int providerId, Location location, ServiceType serviceType, Integer price) {
        this.appointmentId = id;
        this.duration = duration;
        this.date = date;
        this.hourId = hourId;
        this.clientId = clientId;
        this.providerId = providerId;
        this.location = location;
        this.serviceType = serviceType;
        this.price = price;
    }
}
