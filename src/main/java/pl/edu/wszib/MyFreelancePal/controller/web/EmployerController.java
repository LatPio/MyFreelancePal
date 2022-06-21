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
import pl.edu.wszib.MyFreelancePal.controller.mapper.EmployerMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.EmployerService;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

import java.util.List;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    private EmployerMapperDTO employerMapperDTO = Mappers.getMapper(EmployerMapperDTO.class);

    @GetMapping
    public String defaultView() {
        return "redirect:/employer/list";
    }

    @GetMapping("/list")
    public String listview(Model model){
         List<EmployerDTO> allEmployers = employerMapperDTO.mapToDTO(employerService.list());
         model.addAttribute("employers", allEmployers);
         return "employer/employerList";
    }

    @GetMapping("/create")
    public String create(Model model){
         model.addAttribute("newEmployer", new EmployerDTO());
         return "employer/employerCreate";
    }

    @PostMapping("/create")
    public String createAction(EmployerDTO employerDTO, Model model){
        EmployerDomain employerDomain = employerService.create(employerMapperDTO.map(employerDTO));
        return "redirect:/employer";
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model){
         model.addAttribute("updateEmployer", employerMapperDTO.map(employerService.get(id)));
         return "employer/employerUpdate";
    }

    @PostMapping("/update")
    public String updateAction(EmployerDTO employerDTO, Model model){
         EmployerDomain employerDomain = employerService.update(employerMapperDTO.map(employerDTO));
         return "redirect:/employer";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model){
         model.addAttribute("deleteEmployer", employerService.get(id));
         return "employer/employerDelete";
    }
    @PostMapping("/delete")
    public String deleteAction(EmployerDTO employerDTO, Model model){
         employerService.delete(employerDTO.getId());
         return "redirect:/employer";
    }
}
