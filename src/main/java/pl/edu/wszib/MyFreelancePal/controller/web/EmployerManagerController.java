package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.EmployerManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.EmployerManagerService;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;

import javax.validation.Valid;
import java.io.IOException;
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
    public String createAction(@Valid EmployerManagerDTO employerManagerDTO, BindingResult bindingResult, Model model) throws IOException {
        if(bindingResult.hasErrors()){

            model.addAttribute("org.springframework.validation.BindingResult.employerManagerDTO", bindingResult);
            System.out.println("-------------------------------------------");
            System.out.println(bindingResult.getAllErrors().get(0).getCode());
            System.out.println(bindingResult.getAllErrors().get(0).getDefaultMessage());
            System.out.println(bindingResult.getAllErrors());
            System.out.println("-------------------------------------------");
            model.addAttribute(employerManagerDTO);
            return "employerManager/employerManagerCreate";
        }


        employerManagerDTO.setActive(true);
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
