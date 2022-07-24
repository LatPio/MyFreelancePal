package pl.edu.wszib.MyFreelancePal.controller.web;

import org.jetbrains.annotations.NotNull;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.ProjectManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.TaskMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.ProjectManagerService;
import pl.edu.wszib.MyFreelancePal.service.TaskService;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;
import pl.edu.wszib.MyFreelancePal.util.Utilities;


import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/task-manager")
public class TaskManagerController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectManagerService projectManagerService;
    @Autowired
    private Utilities utils;
    private TaskMapperDTO taskMapperDTO = Mappers.getMapper(TaskMapperDTO.class);
    private ProjectManagerMapperDTO projectManagerMapperDTO = Mappers.getMapper(ProjectManagerMapperDTO.class);



    @GetMapping("/create")
    public String create(Model model, @RequestParam Integer id, @RequestParam Integer idOfEmployer) {
        model.addAttribute("newTask", new TaskDTO());
        model.addAttribute("idToPas", id);
        model.addAttribute("idOfEmployer", idOfEmployer);
        return "taskManager/taskManagerCreate";
    }

    @PostMapping("/create")
    public String createAction(TaskDTO taskDTO, Model model, @RequestParam Integer idOfEmployer) {
        BigDecimal price = projectManagerService.get(taskDTO.getProjectDTO().getId()).getHourPriceDefault();
        taskDTO.setHourPrice(price);
        TaskDomain taskDomain = taskService.create(taskMapperDTO.map(taskDTO));
        taskDomain.setDoneTask(Boolean.FALSE);
        return "redirect:/project-manager/list?id=" + idOfEmployer;
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model, @RequestParam Integer idOfEmployer) {
        model.addAttribute("updateTask", taskMapperDTO.map(taskService.get(id)));
        model.addAttribute("idOfEmployer", idOfEmployer);
        return "taskManager/taskManagerUpdate";
    }

    @PostMapping("/update")
    public String updateAction(TaskDTO taskDTO, Model model, @RequestParam Integer idOfEmployer) {
        taskDTO.setTimeOfWorkInMin(utils.workTimeInMinutes(taskDTO.getDateStart(), taskDTO.getDateEnd()));
        TaskDomain taskDomain = taskService.update(taskMapperDTO.map(taskDTO));
        return "redirect:/project-manager/list?id=" + idOfEmployer;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model, @RequestParam Integer idOfEmployer) {
        model.addAttribute("deleteTask", taskService.get(id));
        model.addAttribute("idOfEmployer", idOfEmployer);
        return "taskManager/taskManagerDelete";
    }

    @PostMapping("/delete")
    public String deleteAction(TaskDTO taskDTO, Model model, @RequestParam Integer idOfEmployer) {

        taskService.delete(taskDTO.getId());
        return "redirect:/project-manager/list?id=" + idOfEmployer;
    }

}
