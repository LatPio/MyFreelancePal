package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectManagerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectManagerDomain;

import java.util.List;

@Mapper(uses = {TaskMapperDTO.class})
public interface ProjectManagerMapperDTO {
    ProjectManagerDTO map(ProjectManagerDomain projectManagerDomain);
    ProjectManagerDomain map(ProjectManagerDTO projectManagerDTO);
    List<ProjectManagerDTO> mapToDTO(List<ProjectManagerDomain> projectManagerDomain);


}
