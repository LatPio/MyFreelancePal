package pl.edu.wszib.MyFreelancePal.controller.web;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.ProjectManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.TaskMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.ProjectManagerService;
import pl.edu.wszib.MyFreelancePal.service.TaskService;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;
import pl.edu.wszib.MyFreelancePal.util.Utilities;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;

@Controller
@RequestMapping("/active-task")
public class ActiveTaskController {

    @Autowired
    private ProjectManagerService projectManagerService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private Utilities utils;
    private ProjectManagerMapperDTO projectManagerMapperDTO = Mappers.getMapper(ProjectManagerMapperDTO.class);
    private TaskMapperDTO taskMapperDTO = Mappers.getMapper(TaskMapperDTO.class);
    @GetMapping
    public String defaultView() {
        return "redirect:/active-task/list";
    }

    @GetMapping("/list")
    public String get(Model model){
        model.addAttribute("ProjectsList", projectManagerMapperDTO.mapToDTO(projectManagerService.listActiveProject(true)));
        model.addAttribute("newTask", new TaskDTO());
        model.addAttribute("byIdSort", Comparator.comparing(TaskDTO::getId).reversed());
        return "activeTasks/activeTaskList";
    }

    @PostMapping("/create")
    public String createAction(@Valid TaskDTO taskDTO, BindingResult bindingResult, Model model){
    //        model.addAttribute("hourPriceDefault", projectManagerService.get(taskDTO.getProjectDTO().getId()).getHourPriceDefault());

        if(bindingResult.hasErrors()){
            model.addAttribute("org.springframework.validation.BindingResult.newTask", bindingResult);
            model.addAttribute("ProjectsList", projectManagerMapperDTO.mapToDTO(projectManagerService.listActiveProject(true)));
            model.addAttribute("newTask", taskDTO);
            model.addAttribute("byIdSort", Comparator.comparing(TaskDTO::getId).reversed());
            return "activeTasks/activeTaskList";

        }
//        BigDecimal price = projectManagerService.get(taskDTO.getProjectDTO().getId()).getHourPriceDefault();
//        taskDTO.setHourPrice(price);
        TaskDomain taskDomain = taskService.create(taskMapperDTO.map(taskDTO));
        taskDomain.setDoneTask(Boolean.FALSE);
        return "redirect:/active-task";
    }

    @GetMapping("/updateStartDate")
    public String updateStartAction(@RequestParam Integer id){
        TaskDTO task = taskMapperDTO.map(taskService.get(id));
        task.setDateStart(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        TaskDomain taskDomain = taskService.update(taskMapperDTO.map(task));
        return "redirect:/active-task";
    }

    @GetMapping("/updateEndDate")
    public String updateEndAction(@RequestParam Integer id){
        TaskDTO task = taskMapperDTO.map(taskService.get(id));
        task.setDateEnd(LocalDateTime.now());
        task.setTimeOfWorkInMin(utils.workTimeInMinutes(task.getDateStart(), task.getDateEnd()));
        task.setDoneTask(Boolean.TRUE);
        TaskDomain taskDomain = taskService.update(taskMapperDTO.map(task));
        return "redirect:/active-task";
    }

}
