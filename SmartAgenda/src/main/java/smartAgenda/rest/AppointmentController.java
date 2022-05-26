package smartagenda.rest;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import smartagenda.domain.Appointment;
import smartagenda.rest.exception.AppointmentNotFoundException;
import smartagenda.service.AppointmentService;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class AppointmentController {
    private final AppointmentService appointmentService;

    private final ModelMapper modelMapper;

    public AppointmentController(AppointmentService appointmentService, ModelMapper modelMapper) {
        this.appointmentService = appointmentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("appointments")
    public List<Appointment> getAppointments() {
        List<Appointment> appointments = appointmentService.findAll();
        return appointments;
    }

    @PostMapping("appointments")
    public void createAppointment(@RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);
    }

    @GetMapping("appointment/{appointment_id}")
    public Appointment getFirstByAppointmentId(@PathVariable int appointment_id) {
        Appointment appointment = appointmentService.findFirstByAppointmentId(appointment_id);
        if (appointment == null) {
            throw new AppointmentNotFoundException("No appointment found");
        }
        return appointment;
    }

    @GetMapping("appointments/{personId}")
    public List<Appointment> getAppointmentsForPerson(@PathVariable int personId) {
        List<Appointment> appointments = appointmentService.findAppointmentsForPerson(personId);
        if (appointments.size() == 0) {
            throw new AppointmentNotFoundException("No appointment found for selected person");
        }
        return appointments;
    }

    @GetMapping("appointments/after{date}")
    public List<Appointment> getAppointmentsByDateAfter(@PathVariable Date date) {
        return appointmentService.findAllByDateAfter(date);
    }

    @GetMapping("appointments/{date}")
    public List<Appointment> getAppointmentsByDate(@PathVariable Date date) {
        return appointmentService.findAllByDate(date);
    }
}
