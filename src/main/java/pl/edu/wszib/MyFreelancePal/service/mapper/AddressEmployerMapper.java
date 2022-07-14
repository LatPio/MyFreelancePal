package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;

import java.util.List;

@Mapper
public interface AddressEmployerMapper {



    AddressEmployerDomain map(Address address);


    Address map(AddressEmployerDomain addressEmployerDomain);

    List<AddressEmployerDomain> mapToDomain(List<Address> addresses);

}
