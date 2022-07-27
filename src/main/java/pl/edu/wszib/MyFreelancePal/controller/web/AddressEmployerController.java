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
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.AddressEmployerMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.AddressEmployerService;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/addressEr")
public class AddressEmployerController {

    @Autowired
    private AddressEmployerService addressEmployerService;
    private AddressEmployerMapperDTO addressEmployerMapperDTO = Mappers.getMapper(AddressEmployerMapperDTO.class);

    @GetMapping
    public String list(Model model, @RequestParam Integer id){
        List<AddressEmployerDTO> addressByEmployer = addressEmployerMapperDTO.mapToDTO(addressEmployerService.list2(id));
        return "/";
    }

    @GetMapping("/create")
    public String create(Model model, @RequestParam Integer idOfEmployer) {
        model.addAttribute("newAddress", new AddressEmployerDTO());
        model.addAttribute("idOfEmployer", idOfEmployer);
        return "addressEmployer/addressEmployerCreate";
    }

    @PostMapping("/create")
    public String createAction(@Valid AddressEmployerDTO addressEmployerDTO, BindingResult bindingResult, Model model, @RequestParam Integer idOfEmployer) {
        if(bindingResult.hasErrors()){
            model.addAttribute("org.springframework.validation.BindingResult.newAddress", bindingResult);
            model.addAttribute("newAddress", addressEmployerDTO);
            model.addAttribute("idOfEmployer", idOfEmployer);
            return "addressEmployer/addressEmployerCreate";
        }
        AddressEmployerDomain addressEmployerDomain = addressEmployerService.create(addressEmployerMapperDTO.map(addressEmployerDTO));
        return "redirect:/employer-manager/list";
    }
    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model) {
        model.addAttribute("updateAddressEmployer", addressEmployerMapperDTO.map(addressEmployerService.get(id)));
        return "addressEmployer/addressEmployerUpdate";
    }

    @PostMapping("/update")
    public String updateAction(@Valid AddressEmployerDTO addressEmployerDTO, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("org.springframework.validation.BindingResult.updateAddressEmployer", bindingResult);
            model.addAttribute("updateAddressEmployer", addressEmployerDTO);
            return "addressEmployer/addressEmployerUpdate";
        }
        AddressEmployerDomain addressEmployerDomain = addressEmployerService.update(addressEmployerMapperDTO.map(addressEmployerDTO));
        return "redirect:/employer-manager";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {
        model.addAttribute("deleteAddressEmployer", addressEmployerService.get(id));
        return "addressEmployer/addressEmployerDelete";
    }

    @PostMapping("/delete")
    public String deleteAction(AddressEmployerDTO addressEmployerDTO, Model model) {
        addressEmployerService.delete(addressEmployerDTO.getId());
        return "redirect:/employer-manager";
    }
}
