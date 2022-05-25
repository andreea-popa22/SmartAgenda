package smartagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import smartagenda.domain.Client;
import smartagenda.domain.Location;
import smartagenda.domain.Provider;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findAll();

    @Query(value = "SELECT l FROM Location l WHERE l.name=?1")
    Location findFirstByName(String name);

    @Query(value = "SELECT l FROM Location l WHERE l.location_id=?1")
    Location findFirstById(int locationId);

}
