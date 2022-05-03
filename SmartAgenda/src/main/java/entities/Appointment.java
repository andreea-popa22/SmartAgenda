package entities;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Appointment {
    private int id;
    private LocalDateTime date;
    private Client client;
    private Provider provider;
    private Location location;
    private ServiceType serviceType;
}
