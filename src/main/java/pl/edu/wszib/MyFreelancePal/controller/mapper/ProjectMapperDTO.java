package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

import java.util.List;

@Mapper
public interface ProjectMapperDTO {

    ProjectDTO map(ProjectDomain projectDomain);

    ProjectDomain map(ProjectDTO projectDTO);

    List<ProjectDTO> mapToDTO(List<ProjectDomain> projectDomain);


}
