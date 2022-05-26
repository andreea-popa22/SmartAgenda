package smartagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import smartagenda.domain.Client;
import smartagenda.domain.Gender;
import smartagenda.domain.Person;
import smartagenda.domain.Provider;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAll();

    //@Modifying
    //@Query(value = "INSERT INTO Person (person_type, person_id, name, phone, email, age, gender) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    //void insertPerson(int product_type, int person_id, String name, String phone, String email, int age, Gender gender);

    @Query(value = "SELECT p FROM Person p WHERE p.person_type=1", nativeQuery = true)
    List<Client> findAllClients();

    @Query(value = "SELECT p FROM Person p WHERE p.person_type=2", nativeQuery = true)
    List<Provider> findAllProviders();

    @Query(value = "SELECT p FROM Person p WHERE p.person_id=?1", nativeQuery = true)
    Person findByPersonId(int person_id);
}
