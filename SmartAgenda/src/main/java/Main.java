import storage.PersonRepository;

public class Main {

    public static void main(String[] args) {

        System.out.println("~Clients and providers:");
        PersonRepository personRepository = PersonRepository.getInstance();
        System.out.println(personRepository.toString());

    }
}