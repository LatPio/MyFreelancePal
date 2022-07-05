package pl.edu.wszib.MyFreelancePal.controller.web;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.EmployerManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.EmployerMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.ProjectManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.TaskMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.EmployerManagerService;
import pl.edu.wszib.MyFreelancePal.service.EmployerService;
import pl.edu.wszib.MyFreelancePal.service.ProjectManagerService;
import pl.edu.wszib.MyFreelancePal.service.TaskService;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

import java.util.Comparator;

@Controller
@RequestMapping("/active-task")
public class ActiveTaskController {

    @Autowired
    private ProjectManagerService projectManagerService;
    @Autowired
    private TaskService taskService;
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
        return "activeTasks/activeTaskList";
    }

    @GetMapping("/create")
    public String create(@RequestParam Integer id, Model model){
        model.addAttribute("newProject", new ProjectManagerDTO());
        model.addAttribute("idOfEmployer", id);
        return "projectManager/projectManagerCreate";
    }
    @PostMapping("/create")
    public String createAction(TaskDTO taskDTO, Model model){
        TaskDomain taskDomain = taskService.create(taskMapperDTO.map(taskDTO));
        return "redirect:/active-task";
    }


}
