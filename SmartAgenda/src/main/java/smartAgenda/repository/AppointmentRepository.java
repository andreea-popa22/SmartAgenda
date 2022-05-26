package smartagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import smartagenda.domain.Appointment;
import smartagenda.domain.Schedule;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAll();

    @Query(value = "SELECT a FROM Appointment a WHERE a.date >= ?1")
    List<Appointment> findAllByDateAfter(Date date);

    @Query(value = "SELECT a FROM Appointment a WHERE a.date = ?1")
    List<Appointment> findAllByDate(Date date);

    @Query(value = "SELECT a FROM Appointment a WHERE a.appointment_id=?1", nativeQuery = true)
    Appointment findFirstByAppointmentId(int appointmentId);

    @Query(value = "SELECT * FROM Appointment a WHERE a.person_id=?1", nativeQuery = true)
    List<Appointment> findAppointmentsForPerson(int personId);

//    @Query(value = "SELECT * FROM Appointment a WHERE a.person_id=?1")
//    List<Appointment> findAppointmentsForClient(int personId);
//
//    @Query(value = "SELECT * FROM Appointment a WHERE a.person_id=?1")
//    List<Appointment> findAppointmentsForProvider(int personId);
}
