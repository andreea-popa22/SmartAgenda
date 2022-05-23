package smartagenda.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
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
    private int locationId;
    private ServiceType serviceType;
    private Integer price;

    @Builder
    public Appointment(int id, float duration, Date date, int hourId, int clientId, int providerId, int locationId, ServiceType serviceType, Integer price) {
        this.appointmentId = id;
        this.duration = duration;
        this.date = date;
        this.hourId = hourId;
        this.clientId = clientId;
        this.providerId = providerId;
        this.locationId = locationId;
        this.serviceType = serviceType;
        this.price = price;
    }
}
