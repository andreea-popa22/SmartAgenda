package smartAgenda.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import smartAgenda.entities.Location;
import smartAgenda.storage.LocationRepository;

@RestController
class LocationController {
    @GetMapping("/")
    public String getSomething(){
        return LocationRepository.getInstance().getLocations().toString();
    }

    @PostMapping("locations")
    public void createLocation(@RequestBody Location location) {
       // LocationRepository.getInstance().addLocation(location);
    }
}
