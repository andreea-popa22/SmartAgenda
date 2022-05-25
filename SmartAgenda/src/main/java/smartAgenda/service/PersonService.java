package smartagenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartagenda.domain.Client;
import smartagenda.domain.Person;
import smartagenda.domain.Provider;
import smartagenda.repository.PersonRepository;
import smartagenda.rest.exception.PersonNotFoundException;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void addClient(Client client) {
        personRepository.save(client);
    }

    public void addProvider(Provider provider) {
        personRepository.save(provider);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Client> findAllClients() {
        return personRepository.findAllClients();
    }

    public List<Provider> findAllProviders() {
        return personRepository.findAllProviders();
    }

    public Person findByPersonId(int personId) {
        Person person = personRepository.findByPersonId(personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found with corresponding id.");
        }
        return person;
    }
}
