package smartagenda.service;

import org.springframework.stereotype.Service;
import smartagenda.entities.Location;
import smartagenda.rest.exception.LocationNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    private static final List<Location> locations = new ArrayList<>();

    public void addLocation(Location location){
        locations.add(location);
    }

    public List<Location> findAll(){
        return locations;
    }

    public Location findById(int id){
        return locations.stream()
                .filter(location -> location.getId() == id)
                .findFirst()
                .orElseThrow(() -> new LocationNotFoundException("Location not found"));
    }
}
