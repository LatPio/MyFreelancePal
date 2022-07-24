package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;

import java.util.List;

@Mapper
public interface EmployeeMapperDTO {
    EmployeeDTO map(EmployeeDomain employeeDomain);
    EmployeeDomain map(EmployeeDTO employeeDTO);

    List<EmployeeDTO> mapToDTO(List<EmployeeDomain> employeeDomains);
}
