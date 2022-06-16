package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployeeDTO;

import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;


import java.util.List;

@Mapper
public interface AddressEmployeeMapperDTO {


    @Mapping(source = "employeeDomain", target = "employeeDTO")
    AddressEmployeeDTO map(AddressEmployeeDomain addressEmployeeDomain);
    @Mapping(source = "employeeDTO", target = "employeeDomain")
    AddressEmployeeDomain map(AddressEmployeeDTO addressEmployeeDTO);
    List<AddressEmployeeDTO> mapToDTO(List<AddressEmployeeDomain> addressEmployeeDomains);
}
