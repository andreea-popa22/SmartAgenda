package smartagenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
