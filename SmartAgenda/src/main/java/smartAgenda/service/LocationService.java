package smartAgenda.service;

import org.springframework.stereotype.Service;
import smartAgenda.entities.Location;
import smartAgenda.storage.LocationRepository;
import smartAgenda.rest.exception.LocationNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class LocationService {
    private static final List<Location> locations = new ArrayList<>();

    public void addLocation(Location location){
        locations.add(location);
    }

    public List<Location> findAll(){
        return locations;
    }

    public static Location findById(int id){
        return locations.stream()
                .filter(location -> location.getId() == id)
                .findFirst()
                .orElseThrow(() -> new LocationNotFoundException("Location not found"));
    }
}
