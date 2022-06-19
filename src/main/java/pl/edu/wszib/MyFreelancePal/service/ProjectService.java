package pl.edu.wszib.MyFreelancePal.service;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.repository.ProjectRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.ProjectMapper;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class ProjectService implements CrudService<ProjectDomain, Integer> {

    @Autowired
    private ProjectRepository projectRepository;

    private ProjectMapper mapper = Mappers.getMapper(ProjectMapper.class);

    @Override
    public List<ProjectDomain> list() {
        return mapper.mapToDomain(projectRepository.findAll());
    }

    public List<ProjectDomain> list2(Integer id){ return mapper.mapToDomain(projectRepository.findByEmployer_Id(id));}

    @Override
    public ProjectDomain get(Integer integer) {
        return projectRepository.findById(integer)
                .map(project -> mapper.map(project))
                .orElse(null);
    }

    @Override
    public ProjectDomain create(ProjectDomain projectDomain) {
        projectDomain.setId(null);
        Project created = projectRepository.save(mapper.map(projectDomain));
        return mapper.map(created);
    }

    @Override
    public ProjectDomain update(ProjectDomain projectDomain) {
        ProjectDomain existing = get(projectDomain.getId());
        if(existing == null){
            return null;
        }
        Project updated = projectRepository.save(mapper.map(projectDomain));
         return mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        projectRepository.deleteById(integer);

    }
}
