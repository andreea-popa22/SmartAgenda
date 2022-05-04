import entities.Client;
import storage.PersonRepository;
import storage.Service;

public class Main {

    public static void main(String[] args) {

        String phone1 = "0765457692";
        System.out.println(Service.phoneNumberValidation(phone1));
        String phone2 = "1230756543235";
        System.out.println(Service.phoneNumberValidation(phone2));

//        Client client = Service.addNewClient();
//        System.out.println(client.toString());

        System.out.println("~Clients and providers:");
        PersonRepository personRepository = PersonRepository.getInstance();
        System.out.println(personRepository.toString());

        Client client2 = Service.getClientByPhoneNumber(phone1);
        System.out.println(client2.toString());
    }
}