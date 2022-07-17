package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.model.Task;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Mapping(target = "projectDomain", source = "project")
    TaskDomain map(Task task);

    @Mapping(target = "project", source = "projectDomain")
    Task map(TaskDomain taskDomain);

    List<TaskDomain> mapToDomain(List<Task> tasks);

    List<Task> mapToTasks(List<TaskDomain> taskDomains);

}
