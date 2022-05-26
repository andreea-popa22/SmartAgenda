package smartagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import smartagenda.domain.Schedule;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(value = "SELECT s FROM Schedule WHERE s.personId=?1", nativeQuery = true)
    Schedule findScheduleForPerson(int personId);

    @Query(value = "SELECT s FROM Schedule WHERE s.personId=?1", nativeQuery = true)
    Schedule findScheduleForClient(int personId);

    @Query(value = "SELECT s FROM Schedule WHERE s.personId=?1", nativeQuery = true)
    Schedule findScheduleForProvider(int personId);

}
