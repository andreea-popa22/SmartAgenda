package smartagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import smartagenda.domain.Client;
import smartagenda.domain.Person;
import smartagenda.domain.Provider;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAll();

    @Query(value = "SELECT p FROM Location p WHERE person_type=1")
    List<Client> findAllClients();

    @Query(value = "SELECT p FROM Location p WHERE person_type=2")
    List<Provider> findAllProviders();

    Person findFirstByPersonId(int person_id);
}
