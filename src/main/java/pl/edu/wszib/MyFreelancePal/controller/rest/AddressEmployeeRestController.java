package pl.edu.wszib.MyFreelancePal.controller.rest;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.AddressEmployeeMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.AddressEmployeeService;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;

import java.util.List;

@RestController
@RequestMapping("/rest/address_employee")
public class AddressEmployeeRestController {

    @Autowired
    private AddressEmployeeService addressEmployeeService;

    private final AddressEmployeeMapperDTO addressEmployeeMapperDTO = Mappers.getMapper(AddressEmployeeMapperDTO.class);


//    @GetMapping("/list")
//    public List<AddressEmployeeDTO> list(@RequestParam Integer id) {
//        return addressEmployeeMapperDTO.mapToDTO(addressEmployeeService.list2(id));
//    }

    @GetMapping
    public AddressEmployeeDTO get(@RequestParam Integer id) {
        return addressEmployeeMapperDTO.map(addressEmployeeService.get(id));
    }

    @PostMapping
    public AddressEmployeeDTO create(@RequestBody AddressEmployeeDTO addressEmployeeDTO) {
        AddressEmployeeDomain output = addressEmployeeService.create(
                addressEmployeeMapperDTO.map(addressEmployeeDTO)
        );
        return addressEmployeeMapperDTO.map(output);
    }

    @PutMapping
    public AddressEmployeeDTO update(@RequestBody AddressEmployeeDTO addressEmployeeDTO) {
        AddressEmployeeDomain output = addressEmployeeService.update(
                addressEmployeeMapperDTO.map(addressEmployeeDTO)
        );
        return addressEmployeeMapperDTO.map(output);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        addressEmployeeService.delete(id);
    }
}
