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


import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    private TaskMapperDTO taskMapperDTO = Mappers.getMapper(TaskMapperDTO.class);

    @GetMapping
    public String defaultView() {
        return "redirect:/tasks/list2";
    }


    @GetMapping("/list")
    public String listView(Model model) {
        List<TaskDTO> allTasks = taskMapperDTO.mapToDTO(taskService.list());
        model.addAttribute("tasks", allTasks);
        return "task/taskList";
    }

    @GetMapping("/list2")
    public String listViewByProject(@NotNull Model model, @RequestParam Integer id) {
        List<TaskDTO> TasksByProject = taskMapperDTO.mapToDTO(taskService.list2(id));
        model.addAttribute("id", id);
        model.addAttribute("tasks", TasksByProject);
        return "task/taskList";
    }

    @GetMapping("/create")
    public String create(Model model, @RequestParam Integer id) {
        model.addAttribute("newTask", new TaskDTO());
        model.addAttribute("idToPas", id);
        return "task/taskCreate";
    }

    @PostMapping("/create")
    public String createAction(TaskDTO taskDTO, Model model, @RequestParam Integer id) {
        TaskDomain taskDomain = taskService.create(taskMapperDTO.map(taskDTO));

        return "redirect:/tasks/list2/?id=" + id;
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model) {
        model.addAttribute("updateTask", taskMapperDTO.map(taskService.get(id)));
        return "task/taskUpdate";
    }

    @PostMapping("/update")
    public String updateAction(TaskDTO taskDTO, Model model) {
        TaskDomain taskDomain = taskService.update(taskMapperDTO.map(taskDTO));
        TaskDomain idToPass = taskService.get(taskDTO.getId());
        return "redirect:/tasks/list2/?id=" + idToPass.getProjectDomain().getId();
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {
        model.addAttribute("deleteTask", taskService.get(id));
        return "task/taskDelete";
    }

    @PostMapping("/delete")
    public String deleteAction(TaskDTO taskDTO, Model model) {
        TaskDomain idToPass = taskService.get(taskDTO.getId());
        taskService.delete(taskDTO.getId());
            return "redirect:/tasks/list2/?id=" + idToPass.getProjectDomain().getId();
    }

}
