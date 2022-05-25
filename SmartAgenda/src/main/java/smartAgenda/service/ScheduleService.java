package smartagenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartagenda.domain.Schedule;
import smartagenda.repository.ScheduleRepository;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule findScheduleForPerson(int personId) {
        Schedule schedule = scheduleRepository.findScheduleForPerson(personId);
        return schedule;
    }

    public Schedule findScheduleForClient(int personId) {
        Schedule schedule = scheduleRepository.findScheduleForClient(personId);
        return schedule;
    }

    public Schedule findScheduleForProvider(int personId) {
        Schedule schedule = scheduleRepository.findScheduleForProvider(personId);
        return schedule;
    }
}
