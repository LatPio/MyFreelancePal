package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerManagerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;

import java.util.List;

@Mapper(uses = {ProjectMapperDTO.class})
public interface EmployerManagerMapperDTO {

    @Mapping(source = "employeeDomain", target = "employeeDTO")
    EmployerManagerDTO map(EmployerManagerDomain employerManagerDomain);
    @Mapping(source = "employeeDTO", target = "employeeDomain")
    EmployerManagerDomain map(EmployerManagerDTO employerManagerDTO);

    List<EmployerManagerDTO> mapToDTO(List<EmployerManagerDomain> employerManagerDomains);
}
