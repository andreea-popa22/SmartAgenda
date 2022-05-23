package smartagenda.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import smartagenda.domain.Location;
import smartagenda.rest.dto.LocationOutputDTO;
import smartagenda.service.LocationService;
import smartagenda.storage.LocationRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
class LocationController {
    private final LocationService locationService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public String getSomething(){
        return LocationRepository.getInstance().getLocations().toString();
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
       locationService.addLocation(location);
    }

    @GetMapping("locations/{locationId}")
    public Location getLocation(@PathVariable int locationId) { return locationService.findById(locationId); }
}
