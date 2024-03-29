package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerManagerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;

import java.util.List;

@Mapper(uses = {ProjectMapperDTO.class})
public interface EmployerManagerMapperDTO {

    EmployerManagerDTO map(EmployerManagerDomain employerManagerDomain);
    EmployerManagerDomain map(EmployerManagerDTO employerManagerDTO);
    List<EmployerManagerDTO> mapToDTO(List<EmployerManagerDomain> employerManagerDomains);
}
