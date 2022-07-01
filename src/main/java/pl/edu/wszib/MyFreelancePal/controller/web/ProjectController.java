package pl.edu.wszib.MyFreelancePal.controller.web;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.ProjectMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.ProjectService;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    private ProjectMapperDTO projectMapperDTO = Mappers.getMapper(ProjectMapperDTO.class);

    @GetMapping
    public  String listView(Model model){
        List<ProjectDTO> allProjects = projectMapperDTO.mapToDTO(projectService.list());
        model.addAttribute("projects", allProjects);
        return "project/projectList";
    }
    @GetMapping("/list")
    public  String listViewByEmployer(Model model, @RequestParam Integer id){
        List<ProjectDTO> allProjects = projectMapperDTO.mapToDTO(projectService.list2(id));
        model.addAttribute("id", id);
        model.addAttribute("projects", allProjects);
        return "project/projectList";
    }

    @GetMapping("/create")
    public String create(Model model, @RequestParam Integer id){
        model.addAttribute("newProjekt", new ProjectDTO());
        model.addAttribute("idToPas", id);
        return "project/projectCreate";
    }

    @PostMapping("/create")
    public String createAction(ProjectDTO projectDTO, Model model, @RequestParam Integer id){
        ProjectDomain projectDomain  = projectService.create(projectMapperDTO.map(projectDTO));
        return "redirect:/projects/list?id=" + id;
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model){
        model.addAttribute("updateProject", projectMapperDTO.map(projectService.get(id)));
        return "project/projectUpdate";
    }

    @PostMapping("/update")
    public String updateAction(ProjectDTO projectDTO, Model model){
        ProjectDomain idToPass = projectService.get((projectDTO.getId()));
        ProjectDomain projectDomain  = projectService.update(projectMapperDTO.map(projectDTO));
        return "redirect:/projects/list/?id=" + idToPass.getEmployerDomain().getId();
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model){
        model.addAttribute("deleteProject", projectService.get(id));
        return "project/projectDelete";
    }

    @PostMapping("/delete")
    public String deleteAction(ProjectDTO projectDTO, Model model){
        ProjectDomain idToPass = projectService.get((projectDTO.getId()));
        projectService.delete(projectDTO.getId());
        return "redirect:/projects/list/?id=" + idToPass.getEmployerDomain().getId();
    }

}
