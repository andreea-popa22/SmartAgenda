package smartagenda.storage;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import smartagenda.entities.Client;
import smartagenda.entities.Person;
import smartagenda.entities.Provider;
import smartagenda.entitiesHelpers.Gender;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonRepository {
    private List<Client> clients = new ArrayList<>();
    private List<Provider> providers = new ArrayList<>();
    private List<Person> people = new ArrayList<>();

    private static PersonRepository person_repository_instance = null;

    public static PersonRepository getInstance()
    {
        if (person_repository_instance == null)
            person_repository_instance = new PersonRepository();

        return person_repository_instance;
    }

    private PersonRepository()
    {
        Client client1 = Client.builder()
                .clientId(1)
                .name("Popescu Andra")
                .age(30)
                .email("andra.popescu23@yahoo.com")
                .phone("0765456732")
                .gender(Gender.FEMALE)
                .build();
        Client client2 = Client.builder()
                .clientId(2)
                .name("Popa Andrada")
                .age(26)
                .email("andrada.popa01@yahoo.com")
                .phone("0765457692")
                .gender(Gender.FEMALE)
                .build();
        Client client3 = Client.builder()
                .clientId(3)
                .name("Popovici Alex")
                .age(30)
                .email("alex.popovici13@yahoo.com")
                .phone("0747626732")
                .gender(Gender.MALE)
                .build();
        Provider provider1 = Provider.builder()
                .id(1)
                .name("Muresan Elena")
                .age(35)
                .email("elena-muresan@yahoo.com")
                .phone("0765489632")
                .gender(Gender.FEMALE)
                .build();
        Provider provider2 = Provider.builder()
                .id(2)
                .name("Marcov Elena")
                .age(52)
                .email("elena-marcov20@yahoo.com")
                .phone("0765489987")
                .gender(Gender.FEMALE)
                .build();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        providers.add(provider1);
        providers.add(provider2);
        people.add(client1);
        people.add(client2);
        people.add(client3);
        people.add(provider1);
        people.add(provider2);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Person person : this.people){
            boolean isInstance = person instanceof Client;
            if (isInstance) {
                result.append("Client ");
                result.append(((Client)person).getClientId());
            }
            else {
                result.append("Provider ");
                result.append(((Provider)person).getId());
            }
            result.append(" ");
            result.append(person.getName());
            result.append("\n");
       }
        return result.toString();
    }

}
