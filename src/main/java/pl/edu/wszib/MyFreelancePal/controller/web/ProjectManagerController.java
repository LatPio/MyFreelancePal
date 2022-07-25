package pl.edu.wszib.MyFreelancePal.controller.web;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.EmployerManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.ProjectManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.EmployerManagerService;
import pl.edu.wszib.MyFreelancePal.service.ProjectManagerService;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectManagerDomain;


@Controller
@RequestMapping("/project-manager")
public class ProjectManagerController {

    @Autowired
    private ProjectManagerService projectManagerService;
    @Autowired
    private EmployerManagerService employerManagerService;

    private ProjectManagerMapperDTO projectManagerMapperDTO = Mappers.getMapper(ProjectManagerMapperDTO.class);
    private EmployerManagerMapperDTO employerManagerMapperDTO = Mappers.getMapper(EmployerManagerMapperDTO.class);


    @GetMapping("/list")
    public String get(Model model, @RequestParam Integer id){
        model.addAttribute("EmployerManagerGet", employerManagerMapperDTO.map(employerManagerService.get(id)));
        model.addAttribute("ProjectsList", projectManagerMapperDTO.mapToDTO(projectManagerService.list2(id)));
        return "projectManager/projectManagerList";
    }

    @GetMapping("/create")
    public String create(@RequestParam Integer id, Model model){
        model.addAttribute("newProject", new ProjectManagerDTO());
        model.addAttribute("idOfEmployer", id);
        return "projectManager/projectManagerCreate";
    }

    @PostMapping("/create")
    public String createAction(ProjectManagerDTO projectManagerDTO, Model model, @RequestParam Integer id){
        projectManagerDTO.setActiveProject(true);
        ProjectManagerDomain projectManagerDomain = projectManagerService.create(projectManagerMapperDTO.map(projectManagerDTO));
        return "redirect:/project-manager/list?id=" + id;
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model, @RequestParam Integer idOfEmployer){
        model.addAttribute("idOfEmployer", idOfEmployer);
        model.addAttribute("updateManagerProject", projectManagerMapperDTO.map(projectManagerService.get(id)));
        return "projectManager/projectManagerUpdate";
    }

    @PostMapping("/update")
    public String updateAction(ProjectManagerDTO projectManagerDTO, Model model, @RequestParam Integer idOfEmployer){
        ProjectManagerDomain projectManagerDomain = projectManagerService.update(projectManagerMapperDTO.map(projectManagerDTO));
        return "redirect:/project-manager/list?id=" + idOfEmployer;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model, @RequestParam Integer idOfEmployer){
        model.addAttribute("idOfEmployer", idOfEmployer);
        model.addAttribute("deleteProject", projectManagerService.get(id));
        return "projectManager/projectManagerDelete";
    }

    @PostMapping("/delete")
    public String deleteAction (ProjectManagerDTO projectManagerDTO, Model model, @RequestParam Integer idOfEmployer){
        projectManagerService.delete(projectManagerDTO.getId());
        return "redirect:/project-manager/list?id=" + idOfEmployer;
    }


}
