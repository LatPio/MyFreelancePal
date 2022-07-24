package pl.edu.wszib.MyFreelancePal.controller.rest;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.EmployeeManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.EmployeeManagerService;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeManagerDomain;

import java.util.List;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeManagerService employeeManagerService;
    private EmployeeManagerMapperDTO employeeManagerMapperDTO = Mappers.getMapper(EmployeeManagerMapperDTO.class);

    @GetMapping("/list")
    public List<EmployeeManagerDTO> list(){
        return employeeManagerMapperDTO.mapToDTO(employeeManagerService.list());
    }

    @GetMapping
    public EmployeeManagerDTO get(@RequestParam Integer id) {
        return employeeManagerMapperDTO.map(employeeManagerService.get(id));
    }

    @PostMapping
    public EmployeeManagerDTO create(@RequestBody EmployeeManagerDTO employeeManagerDTO){
        EmployeeManagerDomain output = employeeManagerService.create(
                employeeManagerMapperDTO.map(employeeManagerDTO)
        );
        return employeeManagerMapperDTO.map(output);
    }

    @PutMapping
    public EmployeeManagerDTO update(@RequestBody EmployeeManagerDTO employeeManagerDTO){
        EmployeeManagerDomain output = employeeManagerService.update(
                employeeManagerMapperDTO.map(employeeManagerDTO)
        );
        return employeeManagerMapperDTO.map(output);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        employeeManagerService.delete(id);
    }


}
