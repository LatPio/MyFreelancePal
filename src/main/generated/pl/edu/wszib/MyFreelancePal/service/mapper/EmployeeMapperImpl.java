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
    date = "2022-07-17T10:57:58+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDomain map(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDomain.EmployeeDomainBuilder employeeDomain = EmployeeDomain.builder();

        employeeDomain.id( employee.getId() );
        employeeDomain.name( employee.getName() );
        employeeDomain.nip( employee.getNip() );
        employeeDomain.bankNumber( employee.getBankNumber() );
        employeeDomain.bankIban( employee.getBankIban() );
        employeeDomain.address( addressListToAddressEmployeeDomainList( employee.getAddress() ) );

        return employeeDomain.build();
    }

    @Override
    public Employee map(EmployeeDomain employeeDomain) {
        if ( employeeDomain == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( employeeDomain.getId() );
        employee.name( employeeDomain.getName() );
        employee.nip( employeeDomain.getNip() );
        employee.bankNumber( employeeDomain.getBankNumber() );
        employee.bankIban( employeeDomain.getBankIban() );
        employee.address( addressEmployeeDomainListToAddressList( employeeDomain.getAddress() ) );

        return employee.build();
    }

    @Override
    public List<EmployeeDomain> mapToDomain(List<Employee> employee) {
        if ( employee == null ) {
            return null;
        }

        List<EmployeeDomain> list = new ArrayList<EmployeeDomain>( employee.size() );
        for ( Employee employee1 : employee ) {
            list.add( map( employee1 ) );
        }

        return list;
    }

    protected AddressEmployeeDomain addressToAddressEmployeeDomain(Address address) {
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

        return addressEmployeeDomain.build();
    }

    protected List<AddressEmployeeDomain> addressListToAddressEmployeeDomainList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressEmployeeDomain> list1 = new ArrayList<AddressEmployeeDomain>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressEmployeeDomain( address ) );
        }

        return list1;
    }

    protected Address addressEmployeeDomainToAddress(AddressEmployeeDomain addressEmployeeDomain) {
        if ( addressEmployeeDomain == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.id( addressEmployeeDomain.getId() );
        address.name( addressEmployeeDomain.getName() );
        address.street( addressEmployeeDomain.getStreet() );
        address.postalCode( addressEmployeeDomain.getPostalCode() );
        address.buildingNumber( addressEmployeeDomain.getBuildingNumber() );
        address.flatNumber( addressEmployeeDomain.getFlatNumber() );
        address.city( addressEmployeeDomain.getCity() );
        address.country( addressEmployeeDomain.getCountry() );

        return address.build();
    }

    protected List<Address> addressEmployeeDomainListToAddressList(List<AddressEmployeeDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressEmployeeDomain addressEmployeeDomain : list ) {
            list1.add( addressEmployeeDomainToAddress( addressEmployeeDomain ) );
        }

        return list1;
    }
}
