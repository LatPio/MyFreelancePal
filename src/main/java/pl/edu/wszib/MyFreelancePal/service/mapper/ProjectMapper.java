package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

import java.util.List;

@Mapper(uses = {TaskMapper.class})
public interface ProjectMapper {

    ProjectDomain map(Project project);

    Project map(ProjectDomain projectDomain);

    List<ProjectDomain> mapToDomain(List<Project> projects);
}
