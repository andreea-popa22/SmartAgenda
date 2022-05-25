package smartagenda.rest;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import smartagenda.domain.Client;
import smartagenda.domain.Person;
import smartagenda.domain.Provider;
import smartagenda.service.PersonService;

import java.util.List;

@Slf4j
@RestController
public class PersonController {
    private final PersonService personService;

    private final ModelMapper modelMapper;

    public PersonController(PersonService personService, ModelMapper modelMapper) {
        this.personService = personService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("people")
    public List<Person> getPeople() {
        List<Person> people = personService.findAll();
        return people;
    }

    @GetMapping("clients")
    public List<Client> getClients() {
        return personService.findAllClients();
    }

    @GetMapping("providers")
    public List<Provider> getProviders() {
        return personService.findAllProviders();
    }

    @PostMapping("clients")
    public void createClient(@RequestBody Client client) {
        personService.addClient(client);
    }

    @PostMapping("providers")
    public void createProvider(@RequestBody Provider provider) {
        personService.addProvider(provider);
    }

    @GetMapping("people/{person_id}")
    public Person getPerson(@RequestBody int personId) {
        return personService.findByPersonId(personId);
    }

}
