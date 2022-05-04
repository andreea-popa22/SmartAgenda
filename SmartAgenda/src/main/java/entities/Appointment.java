package entities;

import entitiesHelpers.ServiceType;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Appointment {
    private int id;
    private float duration;
    private LocalDateTime date;
    private Client client;
    private Provider provider;
    private Location location;
    private ServiceType serviceType;
    private Integer price;
}
