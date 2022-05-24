package smartagenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import smartagenda.domain.Client;
import smartagenda.service.Service;
import smartagenda.storage.LocationRepository;
import smartagenda.storage.PersonRepository;

@SpringBootApplication
public class Main {
    //@Autowired
    //private static PersonRepository personRepository = PersonRepository.getInstance();
    //@Autowired
    //private static LocationRepository locationRepository = LocationRepository.getInstance();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        System.out.println("Working");

    }
}
