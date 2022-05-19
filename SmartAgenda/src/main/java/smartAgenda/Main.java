package smartAgenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import smartAgenda.entities.Client;
import smartAgenda.storage.LocationRepository;
import smartAgenda.storage.PersonRepository;
import smartAgenda.storage.Service;

@SpringBootApplication
public class Main {
    private static PersonRepository personRepository = PersonRepository.getInstance();
    private static LocationRepository locationRepository = LocationRepository.getInstance();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        String phone1 = "0765457692";
        // System.out.println(Service.phoneNumberValidation(phone1));
        String phone2 = "1230756543235";
        // System.out.println(Service.phoneNumberValidation(phone2));

        // Client client = Service.addNewClient();
        // System.out.println(client.toString());

        System.out.println("~Clients and providers:");

        System.out.println(personRepository.toString());

        Client client2 = Service.getClientByPhoneNumber(phone1);
        System.out.println(client2.toString());

        Client client1 = Service.getClientById(1);
        System.out.println(client1.toString());
    }
}
