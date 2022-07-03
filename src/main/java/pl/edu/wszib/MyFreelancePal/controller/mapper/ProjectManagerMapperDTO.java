package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectManagerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectManagerDomain;

import java.util.List;

@Mapper(uses = {TaskMapperDTO.class})
public interface ProjectManagerMapperDTO {

//    @Mapping(target = "employerDTO", source = "employerDomain")
    ProjectManagerDTO map(ProjectManagerDomain projectManagerDomain);
//    @Mapping(target = "employerDomain", source = "employerDTO")
    ProjectManagerDomain map(ProjectManagerDTO projectManagerDTO);

    List<ProjectManagerDTO> mapToDTO(List<ProjectManagerDomain> projectManagerDomain);


}
