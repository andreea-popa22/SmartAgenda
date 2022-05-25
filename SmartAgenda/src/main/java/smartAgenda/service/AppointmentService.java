package smartagenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartagenda.domain.Appointment;
import smartagenda.repository.AppointmentRepository;
import smartagenda.rest.exception.AppointmentNotFoundException;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;


    public void addAppointment(Appointment appointment){
        appointmentRepository.save(appointment);
    }

    public List<Appointment> findAll() { return appointmentRepository.findAll(); }

    public List<Appointment> findAllByDateAfter(Date date) {
        List<Appointment> appointments = appointmentRepository.findAllByDateAfter(date);
        return appointments;
    }

    public List<Appointment> findAllByDate(Date date) {
        List<Appointment> appointments = appointmentRepository.findAllByDate(date);
        return appointments;
    }

    public Appointment findAppointmentById(int appointmentId) {
        Appointment appointment = appointmentRepository.findAppointmentById(appointmentId);
        if (appointment == null) {
            throw new AppointmentNotFoundException("Appointment not found");
        }
        return appointment;
    }

    public List<Appointment> findAppointmentsForClient(int personId) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsForClient(personId);
        if (appointments.size() == 0) {
            throw new AppointmentNotFoundException("No appointments for this client yet.");
        }
        return appointments;
    }

    public List<Appointment> findAppointmentsForProvider(int personId) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsForProvider(personId);
        if (appointments.size() == 0) {
            throw new AppointmentNotFoundException("No appointments for this provider yet.");
        }
        return appointments;
    }

    public List<Appointment> findAppointmentsForPerson(int personId) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsForPerson(personId);
        if (appointments.size() == 0) {
            throw new AppointmentNotFoundException("No appointments for this provider yet.");
        }
        return appointments;
    }
}
