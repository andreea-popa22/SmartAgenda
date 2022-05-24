package smartagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smartagenda.domain.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAll();

    Appointment findFirstAppointmentByDate(Date date);
}
