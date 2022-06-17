package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;

import java.util.List;

@Mapper
public interface AddressEmployerMapperDTO {


    @Mapping(source = "employerDomain", target = "employerDTO")
    AddressEmployerDTO map(AddressEmployerDomain addressEmployerDomain);
    @Mapping(source = "employerDTO", target = "employerDomain")
    AddressEmployerDomain map(AddressEmployerDTO addressEmployerDTO);
    List<AddressEmployerDTO> mapToDTO(List<AddressEmployerDomain> addressEmployerDomains);
}