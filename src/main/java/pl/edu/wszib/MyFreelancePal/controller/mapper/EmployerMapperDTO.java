package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

import java.util.List;

@Mapper(uses = {ProjectMapperDTO.class})
public interface EmployerMapperDTO {

    @Mapping(source = "employeeDomain", target = "employeeDTO")
    EmployerDTO map(EmployerDomain employerDomain);
    @Mapping(source = "employeeDTO", target = "employeeDomain")
    EmployerDomain map(EmployerDTO employerDTO);

    List<EmployerDTO> mapToDTO(List<EmployerDomain> employerDomains);
}
