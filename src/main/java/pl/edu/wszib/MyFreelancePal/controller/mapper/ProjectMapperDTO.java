package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

import java.util.List;

@Mapper(uses = {TaskMapperDTO.class})
public interface ProjectMapperDTO {

    @Mapping(target = "employerDTO", source = "employerDomain")
    ProjectDTO map(ProjectDomain projectDomain);
    @Mapping(target = "employerDomain", source = "employerDTO")
    ProjectDomain map(ProjectDTO projectDTO);

    List<ProjectDTO> mapToDTO(List<ProjectDomain> projectDomain);


}
