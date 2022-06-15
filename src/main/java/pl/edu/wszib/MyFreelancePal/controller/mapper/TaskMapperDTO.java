package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

import java.util.List;

@Mapper
public interface TaskMapperDTO {

    TaskDTO map(TaskDomain taskDomain);

    TaskDomain map(TaskDTO taskDTO);

    List<TaskDTO> mapToDTO(List<TaskDomain> taskDomains);
}
