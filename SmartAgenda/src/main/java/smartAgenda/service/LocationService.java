package smartagenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartagenda.domain.Location;
import smartagenda.repository.LocationRepository;
import smartagenda.rest.exception.LocationNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }
    public Location findFirstByName(String name) {
        Location location = locationRepository.findFirstByName(name);
        if (location == null) {
            throw new LocationNotFoundException("Location not found");
        }
        return location;
    }

    public Location findFirstByLocationId(int locationId) {
        Location location = locationRepository.findFirstByLocationId(locationId);
        if (location == null) {
            throw new LocationNotFoundException("Location not found");
        }
        return location;
    }
}
