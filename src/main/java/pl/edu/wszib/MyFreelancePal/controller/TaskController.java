package pl.edu.wszib.MyFreelancePal.controller;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.TaskMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.TaskService;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    private TaskMapperDTO taskMapperDTO = Mappers.getMapper(TaskMapperDTO.class);

    @GetMapping("/list")
    public List<TaskDTO> list(){
        return taskMapperDTO.mapToDTO(taskService.list());
    }

    @GetMapping
    public TaskDTO get(@RequestParam  Integer id) {
        return taskMapperDTO.map(taskService.get(id));
    }

    @PostMapping
        public TaskDTO create(@RequestBody TaskDTO taskDTO) {
        TaskDomain output = taskService.create(
                taskMapperDTO.map(taskDTO)
        );
        return taskMapperDTO.map(output);
    }

    @PutMapping
    public TaskDTO update(@RequestBody TaskDTO taskDTO) {
        TaskDomain output = taskService.update(
                taskMapperDTO.map(taskDTO)
        );
        return taskMapperDTO.map(output);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id){
        taskService.delete(id);
    }

}
