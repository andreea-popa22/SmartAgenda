import storage.PersonRepository;
import storage.Service;

public class Main {

    public static void main(String[] args) {

        System.out.println("~Clients and providers:");
        PersonRepository personRepository = PersonRepository.getInstance();
        System.out.println(personRepository.toString());

        String phone1 = "0756543235";
        System.out.println(Service.phoneNumberValidation(phone1));
        String phone2 = "1230756543235";
        System.out.println(Service.phoneNumberValidation(phone2));
    }
}