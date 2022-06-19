package pl.edu.wszib.MyFreelancePal.controller;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.AddressEmployerMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.AddressEmployerService;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;


import java.util.List;

@RestController
@RequestMapping("/rest/address_employer")
public class AddressEmployerRestController {

    @Autowired
    private AddressEmployerService addressEmployerService;

    private AddressEmployerMapperDTO addressEmployerMapperDTO = Mappers.getMapper(AddressEmployerMapperDTO.class);


    @GetMapping("/list")
    public List<AddressEmployerDTO> list(@RequestParam Integer id){
        return addressEmployerMapperDTO.mapToDTO(addressEmployerService.list2(id));
    }

    @GetMapping
    public AddressEmployerDTO get(@RequestParam Integer id){
        return addressEmployerMapperDTO.map(addressEmployerService.get(id));
    }

    @PostMapping
    public AddressEmployerDTO create(@RequestBody AddressEmployerDTO addressEmployerDTO){
        AddressEmployerDomain output = addressEmployerService.create(
                addressEmployerMapperDTO.map(addressEmployerDTO)
        );
        return addressEmployerMapperDTO.map(output);
    }

    @PutMapping
    public AddressEmployerDTO update(@RequestBody AddressEmployerDTO addressEmployerDTO){
        AddressEmployerDomain output = addressEmployerService.update(
                addressEmployerMapperDTO.map(addressEmployerDTO)
        );
        return addressEmployerMapperDTO.map(output);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id){ addressEmployerService.delete(id);}
}
