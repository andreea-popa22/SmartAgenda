package entities;

import entitiesHelpers.ServiceType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class Appointment {
    private int id;
    private float duration;
    private Date date;
    private Hour time;
    private Client client;
    private Provider provider;
    private Location location;
    private ServiceType serviceType;
    private Integer price;

    @Builder
    public Appointment(int id, float duration, Date date, Hour time, Client client, Provider provider, Location location, ServiceType serviceType, Integer price) {
        this.id = id;
        this.duration = duration;
        this.date = date;
        this.time = time;
        this.client = client;
        this.provider = provider;
        this.location = location;
        this.serviceType = serviceType;
        this.price = price;
    }
}
