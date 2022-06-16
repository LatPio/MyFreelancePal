package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;

import java.util.List;

@Mapper
public interface AddressEmployeeMapper {


    @Mapping(source = "employee", target = "employeeDomain")
    AddressEmployeeDomain map(Address address);

    @Mapping(source = "employeeDomain", target = "employee")
    Address map(AddressEmployeeDomain addressEmployeeDomain);

    List<AddressEmployeeDomain> mapToDomain(List<Address> addresses);

}
