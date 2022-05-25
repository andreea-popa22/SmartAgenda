package smartagenda.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import smartagenda.domain.Location;
import smartagenda.rest.dto.LocationOutputDTO;
import smartagenda.service.LocationService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
class LocationController {
    private final LocationService locationService;
    private final ModelMapper modelMapper;

    public LocationController(LocationService locationService, ModelMapper modelMapper) {
        this.locationService = locationService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String helloWorld(){
        return "Hello, world!";
    }

    @GetMapping("locations")
    public List<LocationOutputDTO> getLocations(){
        List<Location> locationsWithPrivateInfo = locationService.findAll();
        List<LocationOutputDTO> locationsDto = locationsWithPrivateInfo.stream()
                .map( location -> modelMapper.map(location, LocationOutputDTO.class))
                .collect(Collectors.toList());
        return locationsDto;
    }

    @PostMapping("locations")
    public void createLocation(@RequestBody Location location) {
        //TODO validation
        locationService.addLocation(location);
    }

    @GetMapping("locations/{name}")
    public Location getLocation(@PathVariable String name) {
        return locationService.findFirstByName(name);
    }

    @GetMapping("locations/{locationId}")
    public Location getLocation(@PathVariable int locationId) {
        return locationService.findFirstById(locationId);
    }

}
