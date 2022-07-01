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
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.AddressEmployerMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.AddressEmployerService;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

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
    public String create(Model model, @RequestParam Integer id) {
        model.addAttribute("newAddress", new AddressEmployerDTO());
        model.addAttribute("idOfEmployer", id);
        return "addressEmployer/addressEmployerCreate";
    }

    @PostMapping("/create")
    public String createAction(AddressEmployerDTO addressEmployerDTO, Model model) {
        AddressEmployerDomain addressEmployerDomain = addressEmployerService.create(addressEmployerMapperDTO.map(addressEmployerDTO));

        return "redirect:/employer-manager/list";
    }
    @GetMapping("/update")
    public String update(@RequestParam Integer idOfAddress, Model model) {
        model.addAttribute("updateAddressEmployer", addressEmployerMapperDTO.map(addressEmployerService.get(idOfAddress)));
        return "addressEmployer/addressEmployerUpdate";
    }

    @PostMapping("/update")
    public String updateAction(AddressEmployerDTO addressEmployerDTO, Model model) {
        AddressEmployerDomain addressEmployerDomain = addressEmployerService.update(addressEmployerMapperDTO.map(addressEmployerDTO));

        return "redirect:/";
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
