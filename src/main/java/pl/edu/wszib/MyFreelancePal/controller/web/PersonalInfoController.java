package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.EmployeeManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.EmployeeManagerService;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeManagerDomain;

import java.util.List;

@Controller
@RequestMapping("/personalInfo")
public class PersonalInfoController {

    @Autowired
    private EmployeeManagerService employeeManagerService;


    private EmployeeManagerMapperDTO employeeManagerMapperDTO = Mappers.getMapper(EmployeeManagerMapperDTO.class);


    @GetMapping
    public String defaultView() {
        return "redirect:/personalInfo/list";
    }

    @GetMapping("/list")
    public String listview(Model model){
        List<EmployeeManagerDTO> allEmployees = employeeManagerMapperDTO.mapToDTO(employeeManagerService.list());
        model.addAttribute("employees", allEmployees);
        return "personalInfo/personalInfoList";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("newEmployee", new EmployeeManagerDTO());

        return "personalInfo/personalInfoCreate";
    }

    @PostMapping("/create")
    public String createAction(EmployeeManagerDTO employeeManagerDTO, Model model){
        EmployeeManagerDomain employeeManagerDomain = employeeManagerService.create(employeeManagerMapperDTO.map(employeeManagerDTO));
        return "redirect:/personalInfo";
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model){
        model.addAttribute("updateEmployee", employeeManagerMapperDTO.map(employeeManagerService.get(id)));

        return "personalInfo/personalInfoUpdate";
    }

    @PostMapping("/update")
    public String updateAction(EmployeeManagerDTO employeeManagerDTO, Model model){
        EmployeeManagerDomain employeeManagerDomain = employeeManagerService.update(employeeManagerMapperDTO.map(employeeManagerDTO));
        return "redirect:/personalInfo";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model){
        model.addAttribute("deleteEmployee", employeeManagerService.get(id));
        return "personalInfo/personalInfoDelete";
    }
    @PostMapping("/delete")
    public String deleteAction(EmployeeManagerDomain employeeManagerDomain, Model model){
        employeeManagerService.delete(employeeManagerDomain.getId());
        return "redirect:/personalInfo";
    }
}
