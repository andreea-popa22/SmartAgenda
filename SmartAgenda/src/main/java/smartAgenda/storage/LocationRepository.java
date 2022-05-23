package smartagenda.storage;

import lombok.Getter;
import lombok.Setter;
import lombok.Singleton;
import smartagenda.domain.Location;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Singleton
public class LocationRepository {
    private List<Location> locations = new ArrayList<>();

    private LocationRepository() {
        Location location1 = Location.builder()
                .locationId(1)
                .name("Salon Coquette")
                .address("Strada Libertatii 14")
                .contact("0754323456")
                .build();
        Location location2 = Location.builder()
                .locationId(2)
                .name("Ateneul Roman")
                .address("Strada Mures 24")
                .contact("0754326786")
                .build();
        Location location3 = Location.builder()
                .locationId(1)
                .name("Sala Palatului")
                .address("Bulevardul Carol 2")
                .contact("0752123456")
                .build();
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
    }
}
