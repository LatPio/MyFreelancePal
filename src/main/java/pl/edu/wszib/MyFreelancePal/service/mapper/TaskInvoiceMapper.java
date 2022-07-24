package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.model.Task;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskInvoiceDomain;

import java.util.List;

@Mapper
public interface TaskInvoiceMapper {

    @Mapping(target = "projectDomain", source = "project")
    TaskInvoiceDomain map(Task task);
    @Mapping(target = "project", source = "projectDomain")
    Task map(TaskInvoiceDomain taskInvoiceDomain);
    List<TaskInvoiceDomain> mapToDomain(List<Task> tasks);
    List<Task> mapToTasks(List<TaskInvoiceDomain> taskInvoiceDomains);

}
