package smartagenda.rest;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import smartagenda.domain.Schedule;
import smartagenda.service.ScheduleService;

@Slf4j
@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;

    private final ModelMapper modelMapper;

    public ScheduleController(ScheduleService scheduleService, ModelMapper modelMapper) {
        this.scheduleService = scheduleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("schedules/{person_id}")
    public Schedule getScheduleForPerson(@PathVariable int personId){
        return scheduleService.findScheduleForPerson(personId);
    }

}
