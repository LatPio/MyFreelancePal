package pl.edu.wszib.MyFreelancePal.controller.rest;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.ProjectMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.ProjectService;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

import java.util.List;

@RestController
@RequestMapping("/rest/project")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;
    private ProjectMapperDTO projectMapperDTO = Mappers.getMapper(ProjectMapperDTO.class);

    @GetMapping("/list")
    public List<ProjectDTO> list() {
        return projectMapperDTO.mapToDTO(projectService.list());
    }

    @GetMapping("/list2")
    public List<ProjectDTO> list2(@RequestParam Integer id) {return projectMapperDTO.mapToDTO(projectService.list2(id));}

    @GetMapping
    public ProjectDTO get(@RequestParam Integer id) {
        return projectMapperDTO.map(projectService.get(id));
    }

    @PostMapping
    public ProjectDTO create(@RequestBody ProjectDTO projectDTO){
        ProjectDomain output = projectService.create(
                projectMapperDTO.map(projectDTO)
        );
        return projectMapperDTO.map(output);
    }

    @PutMapping
    public ProjectDTO update(@RequestBody ProjectDTO projectDTO){
        ProjectDomain output = projectService.update(
                projectMapperDTO.map(projectDTO)
        );
        return projectMapperDTO.map(output);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        projectService.delete(id);
    }

}
