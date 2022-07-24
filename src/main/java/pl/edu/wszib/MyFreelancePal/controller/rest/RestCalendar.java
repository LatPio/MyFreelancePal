package pl.edu.wszib.MyFreelancePal.controller.rest;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.MyFreelancePal.controller.mapper.EventMapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.Event;
import pl.edu.wszib.MyFreelancePal.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestCalendar {

    @Autowired
    private TaskService taskService;

    private EventMapper eventMapper = Mappers.getMapper(EventMapper.class);


    @GetMapping("/calendarData")
    public List<Event> getMappedEvents(){
        return eventMapper.mapToDTO(taskService.list());
    }

}

