package pl.edu.wszib.MyFreelancePal.service;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.repository.ProjectRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.ProjectManagerMapper;

import java.util.List;

@Service
public class ProjectManagerService implements CrudService<ProjectManagerDomain, Integer> {

    @Autowired
    private ProjectRepository projectRepository;

    private ProjectManagerMapper mapper = Mappers.getMapper(ProjectManagerMapper.class);

    @Override
    public List<ProjectManagerDomain> list() {
        return mapper.mapToDomain(projectRepository.findAll());
    }

    public List<ProjectManagerDomain> list2(Integer id){ return mapper.mapToDomain(projectRepository.findByEmployer_Id(id));}
    public List<ProjectManagerDomain> listActiveProject(boolean b){ return mapper.mapToDomain(projectRepository.findByActiveProject(b));}

    public Integer countActiveProject(boolean b){ return projectRepository.countAllByActiveProject(b);}
    public Long countProject(){ return projectRepository.count();}
    @Override
    public ProjectManagerDomain get(Integer integer) {
        return projectRepository.findById(integer)
                .map(project -> mapper.map(project))
                .orElse(null);
    }

    @Override
    public ProjectManagerDomain create(ProjectManagerDomain projectManagerDomain) {
        projectManagerDomain.setId(null);
        Project created = projectRepository.save(mapper.map(projectManagerDomain));
        return mapper.map(created);
    }

    @Override
    public ProjectManagerDomain update(ProjectManagerDomain projectManagerDomain) {
        ProjectManagerDomain existing = get(projectManagerDomain.getId());
        if(existing == null){
            return null;
        }
        Project updated = projectRepository.save(mapper.map(projectManagerDomain));
         return mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        projectRepository.deleteById(integer);

    }
}
