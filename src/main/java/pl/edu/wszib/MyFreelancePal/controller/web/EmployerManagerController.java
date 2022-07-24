package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.AddressEmployerMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.EmployerManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.EmployerMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.ProjectManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.AddressEmployerService;
import pl.edu.wszib.MyFreelancePal.service.EmployerManagerService;
import pl.edu.wszib.MyFreelancePal.service.EmployerService;
import pl.edu.wszib.MyFreelancePal.service.ProjectManagerService;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping("/employer-manager")
public class EmployerManagerController {
    @Autowired
    private EmployerManagerService employerManagerService;


    private EmployerManagerMapperDTO employerManagerMapperDTO = Mappers.getMapper(EmployerManagerMapperDTO.class);


    @GetMapping
    public String defaultView() {
        return "redirect:/employer-manager/list";
    }

    @GetMapping("/list")
    public String listview(Model model){
        List<EmployerManagerDTO> allEmployers = employerManagerMapperDTO.mapToDTO(employerManagerService.list());
        model.addAttribute("employers", allEmployers);
        model.addAttribute("test", allEmployers.size());


        return "employerManager/employerManagerList";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("newEmployer", new EmployerManagerDTO());

        return "employerManager/employerManagerCreate";
    }

    @PostMapping("/create")
    public String createAction(EmployerManagerDTO employerManagerDTO, Model model){
        EmployerManagerDomain employerManagerDomain = employerManagerService.create(employerManagerMapperDTO.map(employerManagerDTO));
        return "redirect:/employer-manager";
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model){
        model.addAttribute("updateManagerEmployer", employerManagerMapperDTO.map(employerManagerService.get(id)));

        return "employerManager/employerManagerUpdate";
    }

    @PostMapping("/update")
    public String updateAction(EmployerManagerDTO employerManagerDTO, Model model){
        EmployerManagerDomain employerManagerDomain = employerManagerService.update(employerManagerMapperDTO.map(employerManagerDTO));
        return "redirect:/employer-manager";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model){
        model.addAttribute("deleteEmployer", employerManagerService.get(id));
        return "employerManager/employerManagerDelete";
    }
    @PostMapping("/delete")
    public String deleteAction(EmployerManagerDTO employerManagerDTO, Model model){
        employerManagerService.delete(employerManagerDTO.getId());
        return "redirect:/employer-manager";
    }
}
