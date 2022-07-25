package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeManagerDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-25T23:57:26+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployeeManagerMapperImpl implements EmployeeManagerMapper {

    @Override
    public EmployeeManagerDomain map(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeManagerDomain.EmployeeManagerDomainBuilder employeeManagerDomain = EmployeeManagerDomain.builder();

        employeeManagerDomain.id( employee.getId() );
        employeeManagerDomain.name( employee.getName() );
        employeeManagerDomain.nip( employee.getNip() );
        employeeManagerDomain.description( employee.getDescription() );
        employeeManagerDomain.phone( employee.getPhone() );
        employeeManagerDomain.email( employee.getEmail() );
        employeeManagerDomain.bankNumber( employee.getBankNumber() );
        employeeManagerDomain.bankIban( employee.getBankIban() );
        employeeManagerDomain.address( addressListToAddressEmployeeDomainList( employee.getAddress() ) );

        return employeeManagerDomain.build();
    }

    @Override
    public Employee map(EmployeeManagerDomain employeeManagerDomain) {
        if ( employeeManagerDomain == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( employeeManagerDomain.getId() );
        employee.name( employeeManagerDomain.getName() );
        employee.nip( employeeManagerDomain.getNip() );
        employee.description( employeeManagerDomain.getDescription() );
        employee.phone( employeeManagerDomain.getPhone() );
        employee.email( employeeManagerDomain.getEmail() );
        employee.bankNumber( employeeManagerDomain.getBankNumber() );
        employee.bankIban( employeeManagerDomain.getBankIban() );
        employee.address( addressEmployeeDomainListToAddressList( employeeManagerDomain.getAddress() ) );

        return employee.build();
    }

    @Override
    public List<EmployeeManagerDomain> mapToDomain(List<Employee> employee) {
        if ( employee == null ) {
            return null;
        }

        List<EmployeeManagerDomain> list = new ArrayList<EmployeeManagerDomain>( employee.size() );
        for ( Employee employee1 : employee ) {
            list.add( map( employee1 ) );
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
        addressEmployeeDomain.employee( employeeToEmployeeDomain( address.getEmployee() ) );

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

    protected Employee employeeDomainToEmployee(EmployeeDomain employeeDomain) {
        if ( employeeDomain == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( employeeDomain.getId() );
        employee.name( employeeDomain.getName() );

        return employee.build();
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
        address.employee( employeeDomainToEmployee( addressEmployeeDomain.getEmployee() ) );

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
