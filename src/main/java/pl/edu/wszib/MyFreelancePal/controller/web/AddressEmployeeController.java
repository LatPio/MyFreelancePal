package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.AddressEmployeeMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.AddressEmployeeService;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/addressEe")
public class AddressEmployeeController {

    @Autowired
    private AddressEmployeeService addressEmployeeService;
    private AddressEmployeeMapperDTO addressEmployeeMapperDTO = Mappers.getMapper(AddressEmployeeMapperDTO.class);

    @GetMapping
    public String list(Model model, @RequestParam Integer id){
        List<AddressEmployeeDTO> addressByEmployee = addressEmployeeMapperDTO.mapToDTO(addressEmployeeService.list2(id));
        return "/";
    }

    @GetMapping("/create")
    public String create(Model model, @RequestParam Integer idOfEmployee) {
        model.addAttribute("newAddress", new AddressEmployeeDTO());
        model.addAttribute("idOfEmployee", idOfEmployee);
        return "addressEmployee/addressEmployeeCreate";
    }

    @PostMapping("/create")
    public String createAction(@Valid AddressEmployeeDTO addressEmployeeDTO, BindingResult bindingResult, Model model, @RequestParam Integer idOfEmployee) {
        if(bindingResult.hasErrors()){
            model.addAttribute("org.springframework.validation.BindingResult.newAddress", bindingResult);
            model.addAttribute("newAddress", addressEmployeeDTO);
            model.addAttribute("idOfEmployee", idOfEmployee);
            return "addressEmployee/addressEmployeeCreate";
        }
        AddressEmployeeDomain addressEmployeeDomain = addressEmployeeService.create(addressEmployeeMapperDTO.map(addressEmployeeDTO));
        return "redirect:/personalInfo";
    }
    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model) {
        model.addAttribute("updateAddressEmployee", addressEmployeeMapperDTO.map(addressEmployeeService.get(id)));
        return "addressEmployee/addressEmployeeUpdate";
    }

    @PostMapping("/update")
    public String updateAction(@Valid AddressEmployeeDTO addressEmployeeDTO, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("org.springframework.validation.BindingResult.updateAddressEmployee", bindingResult);
            model.addAttribute("updateAddressEmployee", addressEmployeeDTO);
            return "addressEmployee/addressEmployeeUpdate";
        }
        AddressEmployeeDomain addressEmployeeDomain = addressEmployeeService.update(addressEmployeeMapperDTO.map(addressEmployeeDTO));
        return "redirect:/personalInfo";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {
        model.addAttribute("deleteAddressEmployee", addressEmployeeService.get(id));
        return "addressEmployee/addressEmployeeDelete";
    }

    @PostMapping("/delete")
    public String deleteAction(AddressEmployerDTO addressEmployerDTO, Model model) {
        addressEmployeeService.delete(addressEmployerDTO.getId());
        return "redirect:/personalInfo";
    }
}
