package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

import java.util.List;

@Mapper
public interface TaskMapperDTO {

    @Mapping(target = "projectDTO", source = "projectDomain")
    TaskDTO  map(TaskDomain taskDomain);

    @Mapping(target = "projectDomain", source = "projectDTO")
    TaskDomain map(TaskDTO taskDTO);

    List<TaskDTO> mapToDTO(List<TaskDomain> taskDomains);

    List<TaskDomain> mapToDomain(List<TaskDTO> taskDTOS);



}
