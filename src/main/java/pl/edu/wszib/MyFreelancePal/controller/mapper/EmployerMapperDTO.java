package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

import java.util.List;
@Mapper(uses = {ProjectMapperDTO.class})
public interface EmployerMapperDTO {
    EmployerDTO map(EmployerDomain employerDomain);
    EmployerDomain map(EmployerDTO employerDTO);
    List<EmployerDTO> mapToDTO(List<EmployerDomain> employerDomains);
}
