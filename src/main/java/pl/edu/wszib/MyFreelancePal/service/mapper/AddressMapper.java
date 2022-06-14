package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressDomain;

import java.util.List;

@Mapper
public interface AddressMapper {

    AddressDomain map(Address address);
    Address map(AddressDomain addressDomain);

    List<AddressDomain> mapToDomain(List<Address> addresses);

}
