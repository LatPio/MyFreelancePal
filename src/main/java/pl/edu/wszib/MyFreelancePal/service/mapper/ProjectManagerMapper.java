package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectManagerDomain;

import java.util.List;

@Mapper(uses = {TaskMapper.class})
public interface ProjectManagerMapper {

//    @Mapping(target = "employerDomain", source = "employer")
    ProjectManagerDomain map(Project project);
//    @Mapping(target = "employer", source = "employerDomain")
    Project map(ProjectManagerDomain projectDomain);

    List<ProjectManagerDomain> mapToDomain(List<Project> projects);
}
