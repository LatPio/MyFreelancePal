package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.model.Task;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

import java.util.List;

@Mapper
public interface TaskMapper {


    TaskDomain map(Task task);

    Task map(TaskDomain taskDomain);

    List<TaskDomain> mapToDomain(List<Task> tasks);

}
