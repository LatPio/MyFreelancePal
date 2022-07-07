package pl.edu.wszib.MyFreelancePal.controller.web;

import org.jetbrains.annotations.NotNull;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.TaskMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.TaskService;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;
import pl.edu.wszib.MyFreelancePal.util.Utilities;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping("/task-manager")
public class TaskManagerController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private Utilities utils;
    private TaskMapperDTO taskMapperDTO = Mappers.getMapper(TaskMapperDTO.class);



//    @GetMapping("/list")
//    public String listView(Model model) {
//        List<TaskDTO> allTasks = taskMapperDTO.mapToDTO(taskService.list());
//        model.addAttribute("tasks", allTasks);
//        return "task/taskList";
//    }
//
//    @GetMapping("/list2")
//    public String listViewByProject(@NotNull Model model, @RequestParam Integer id) {
//        List<TaskDTO> TasksByProject = taskMapperDTO.mapToDTO(taskService.list2(id));
//        model.addAttribute("id", id);
//        model.addAttribute("tasks", TasksByProject);
//        return "task/taskList";
//    }

    @GetMapping("/create")
    public String create(Model model, @RequestParam Integer id, @RequestParam Integer idOfEmployer) {
        model.addAttribute("newTask", new TaskDTO());
        model.addAttribute("idToPas", id);
        model.addAttribute("idOfEmployer", idOfEmployer);
        return "taskManager/taskManagerCreate";
    }

    @PostMapping("/create")
    public String createAction(TaskDTO taskDTO, Model model, @RequestParam Integer idOfEmployer) {
        TaskDomain taskDomain = taskService.create(taskMapperDTO.map(taskDTO));

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
