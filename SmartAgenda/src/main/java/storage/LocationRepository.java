package storage;

import entities.Client;
import entities.Location;
import entities.Person;
import entitiesHelpers.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LocationRepository {
    private List<Location> locations = new ArrayList<>();

    private static LocationRepository location_repository_instance = null;

    public static LocationRepository getInstance()
    {
        if (location_repository_instance == null)
            location_repository_instance = new LocationRepository();

        return location_repository_instance;
    }

    private LocationRepository() {
        Location location1 = Location.builder()
                .id(1)
                .name("Salon Coquette")
                .address("Strada Libertatii 14")
                .contact("0754323456")
                .build();
        Location location2 = Location.builder()
                .id(2)
                .name("Ateneul Roman")
                .address("Strada Mures 24")
                .contact("0754326786")
                .build();
        Location location3 = Location.builder()
                .id(1)
                .name("Sala Palatului")
                .address("Bulevardul Carol 2")
                .contact("0752123456")
                .build();
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
    }
}
