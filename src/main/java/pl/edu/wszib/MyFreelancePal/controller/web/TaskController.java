package pl.edu.wszib.MyFreelancePal.controller.web;

import org.jetbrains.annotations.NotNull;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.TaskMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.TaskService;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;


import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    private TaskMapperDTO taskMapperDTO = Mappers.getMapper(TaskMapperDTO.class);

    @GetMapping("/list")
    public String listView(@NotNull Model model) {
        List<TaskDTO> allTasks = taskMapperDTO.mapToDTO(taskService.list());
        model.addAttribute("tasks", allTasks);
        return "task/taskList";
    }

    @GetMapping("/list2")
    public String listViewByProject(@NotNull Model model, @RequestParam Integer id) {
        List<TaskDTO> TasksByProject = taskMapperDTO.mapToDTO(taskService.list2(id));
        model.addAttribute("tasks", TasksByProject);
        return "task/taskList";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("newTask", new TaskDTO());
        return "task/taskCreate";
    }

    @PostMapping("/create")
    public String createAction(TaskDTO taskDTO, Model model) {
        TaskDomain taskDomain = taskService.create(taskMapperDTO.map(taskDTO));
        return "redirect:/tasks";
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model) {
        model.addAttribute("updateTask", taskMapperDTO.map(taskService.get(id)));
        return "task/taskUpdate";
    }

    @PostMapping("/update")
    public String updateAction(TaskDTO taskDTO, Model model) {
        TaskDomain taskDomain = taskService.update(taskMapperDTO.map(taskDTO));
        return "redirect:/tasks";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {
        model.addAttribute("deleteTask", taskService.get(id));
        return "task/taskDelete";
    }

    @PostMapping("/delete")
    public String deleteAction(TaskDTO taskDTO, Model model) {
        taskService.delete(taskDTO.getId());
        return "redirect:/tasks";
    }

}
