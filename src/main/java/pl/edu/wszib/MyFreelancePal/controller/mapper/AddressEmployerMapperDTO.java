package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;

import java.util.List;

@Mapper
public interface AddressEmployerMapperDTO {
    AddressEmployerDTO map(AddressEmployerDomain addressEmployerDomain);
    AddressEmployerDomain map(AddressEmployerDTO addressEmployerDTO);
    List<AddressEmployerDTO> mapToDTO(List<AddressEmployerDomain> addressEmployerDomains);
}
