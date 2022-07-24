package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectManagerDomain;

import java.util.List;

@Mapper(uses = {TaskMapper.class})
public interface ProjectManagerMapper {

    ProjectManagerDomain map(Project project);
    Project map(ProjectManagerDomain projectDomain);
    List<ProjectManagerDomain> mapToDomain(List<Project> projects);
}
