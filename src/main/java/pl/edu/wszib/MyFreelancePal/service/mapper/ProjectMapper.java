package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

import java.util.List;

@Mapper(uses = {TaskMapper.class})
public interface ProjectMapper {

    @Mapping(target = "employerDomain", source = "employer")
    ProjectDomain map(Project project);
    @Mapping(target = "employer", source = "employerDomain")
    Project map(ProjectDomain projectDomain);
    List<ProjectDomain> mapToDomain(List<Project> projects);
}
