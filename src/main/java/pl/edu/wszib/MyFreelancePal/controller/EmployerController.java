package pl.edu.wszib.MyFreelancePal.controller;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.EmployerMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.EmployerService;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    private EmployerMapperDTO employerMapperDTO = Mappers.getMapper(EmployerMapperDTO.class);

    @GetMapping("/list")
    public List<EmployerDTO> list(){
        return employerMapperDTO.mapToDTO(employerService.list());
    }

    @GetMapping
    public EmployerDTO get(@RequestParam Integer id) {
        return employerMapperDTO.map(employerService.get(id));
    }

    @PostMapping
    public EmployerDTO create(@RequestBody EmployerDTO employerDTO){
        EmployerDomain output = employerService.create(
                employerMapperDTO.map(employerDTO)
        );
        return employerMapperDTO.map(output);
    }

    @PutMapping
    public EmployerDTO update(@RequestBody EmployerDTO employerDTO){
        EmployerDomain output = employerService.update(
                employerMapperDTO.map(employerDTO)
        );
        return employerMapperDTO.map(output);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        employerService.delete(id);
    }


}
