package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-29T13:06:04+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class AddressEmployeeMapperImpl implements AddressEmployeeMapper {

    @Override
    public AddressEmployeeDomain map(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEmployeeDomain.AddressEmployeeDomainBuilder addressEmployeeDomain = AddressEmployeeDomain.builder();

        addressEmployeeDomain.id( address.getId() );
        addressEmployeeDomain.name( address.getName() );
        addressEmployeeDomain.street( address.getStreet() );
        addressEmployeeDomain.postalCode( address.getPostalCode() );
        addressEmployeeDomain.buildingNumber( address.getBuildingNumber() );
        addressEmployeeDomain.flatNumber( address.getFlatNumber() );
        addressEmployeeDomain.city( address.getCity() );
        addressEmployeeDomain.country( address.getCountry() );
        addressEmployeeDomain.employee( employeeToEmployeeDomain( address.getEmployee() ) );

        return addressEmployeeDomain.build();
    }

    @Override
    public Address map(AddressEmployeeDomain addressEmployeeDomain) {
        if ( addressEmployeeDomain == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressEmployeeDomain.getId() );
        address.setName( addressEmployeeDomain.getName() );
        address.setStreet( addressEmployeeDomain.getStreet() );
        address.setPostalCode( addressEmployeeDomain.getPostalCode() );
        address.setBuildingNumber( addressEmployeeDomain.getBuildingNumber() );
        address.setFlatNumber( addressEmployeeDomain.getFlatNumber() );
        address.setCity( addressEmployeeDomain.getCity() );
        address.setCountry( addressEmployeeDomain.getCountry() );
        address.setEmployee( employeeDomainToEmployee( addressEmployeeDomain.getEmployee() ) );

        return address;
    }

    @Override
    public List<AddressEmployeeDomain> mapToDomain(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressEmployeeDomain> list = new ArrayList<AddressEmployeeDomain>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( map( address ) );
        }

        return list;
    }

    protected EmployeeDomain employeeToEmployeeDomain(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDomain.EmployeeDomainBuilder employeeDomain = EmployeeDomain.builder();

        employeeDomain.id( employee.getId() );
        employeeDomain.name( employee.getName() );

        return employeeDomain.build();
    }

    protected Employee employeeDomainToEmployee(EmployeeDomain employeeDomain) {
        if ( employeeDomain == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDomain.getId() );
        employee.setName( employeeDomain.getName() );

        return employee;
    }
}
