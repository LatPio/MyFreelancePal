package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeManagerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeManagerDomain;

import java.util.List;

@Mapper
public interface EmployeeManagerMapperDTO {

    EmployeeManagerDTO map(EmployeeManagerDomain employeeManagerDomain);

    EmployeeManagerDomain map(EmployeeManagerDTO employeeManagerDTO);

    List<EmployeeManagerDTO> mapToDTO(List<EmployeeManagerDomain> employeeManagerDomains);
}
