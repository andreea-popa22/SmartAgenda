package smartagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import smartagenda.domain.Client;
import smartagenda.domain.Location;
import smartagenda.domain.Provider;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findAll();

    Location findByName(String name);

}
