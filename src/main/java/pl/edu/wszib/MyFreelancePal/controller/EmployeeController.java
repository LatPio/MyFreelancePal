package pl.edu.wszib.MyFreelancePal.controller;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.EmployeeMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.EmployeeService;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private EmployeeMapperDTO employeeMapperDTO = Mappers.getMapper(EmployeeMapperDTO.class);

    @GetMapping("/list")
    public List<EmployeeDTO> list(){
        return employeeMapperDTO.mapToDTO(employeeService.list());
    }

    @GetMapping
    public EmployeeDTO get(@RequestParam Integer id) {
        return employeeMapperDTO.map(employeeService.get(id));
    }

    @PostMapping
    public EmployeeDTO create(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDomain output = employeeService.create(
                employeeMapperDTO.map(employeeDTO)
        );
        return employeeMapperDTO.map(output);
    }

    @PutMapping
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDomain output = employeeService.update(
                employeeMapperDTO.map(employeeDTO)
        );
        return employeeMapperDTO.map(output);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        employeeService.delete(id);
    }


}
