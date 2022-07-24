package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;

import java.util.List;

@Mapper
public interface AddressEmployeeMapper {

    AddressEmployeeDomain map(Address address);
    Address map(AddressEmployeeDomain addressEmployeeDomain);
    List<AddressEmployeeDomain> mapToDomain(List<Address> addresses);

}
