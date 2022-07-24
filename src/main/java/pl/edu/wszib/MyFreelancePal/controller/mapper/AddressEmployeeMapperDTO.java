package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployeeDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;


import java.util.List;

@Mapper
public interface AddressEmployeeMapperDTO {
    AddressEmployeeDTO map(AddressEmployeeDomain addressEmployeeDomain);
    AddressEmployeeDomain map(AddressEmployeeDTO addressEmployeeDTO);
    List<AddressEmployeeDTO> mapToDTO(List<AddressEmployeeDomain> addressEmployeeDomains);
}
