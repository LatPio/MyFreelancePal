package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Task;
import pl.edu.wszib.MyFreelancePal.repository.TaskRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.TaskMapper;

import java.util.List;

@Service
public class TaskService implements CrudService<TaskDomain, Integer> {

    @Autowired
    private TaskRepository taskRepository;

    private TaskMapper mapper = Mappers.getMapper(TaskMapper.class);

    @Override
    public List<TaskDomain> list() {
        return mapper.mapToDomain(taskRepository.findAll());
    }

    @Override
    public TaskDomain get(Integer integer) {
        return taskRepository.findById(integer)
                .map(task -> mapper.map(task))
                .orElse(null);
    }

    @Override
    public TaskDomain create(TaskDomain taskDomain) {
        taskDomain.setId(null);
        Task created = taskRepository.save(mapper.map(taskDomain));
        return mapper.map(created);
    }

    @Override
    public TaskDomain update(TaskDomain taskDomain) {
        TaskDomain existing = get(taskDomain.getId());
        if(existing == null) {
            return null;
        }
        Task updated = taskRepository.save(mapper.map(taskDomain));
        return mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        taskRepository.deleteById(integer);
    }
}