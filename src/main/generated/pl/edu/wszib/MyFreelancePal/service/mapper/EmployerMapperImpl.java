package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-01T19:26:51+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployerMapperImpl implements EmployerMapper {

    private final AddressEmployerMapper addressEmployerMapper = Mappers.getMapper( AddressEmployerMapper.class );

    @Override
    public EmployerDomain map(Employer employer) {
        if ( employer == null ) {
            return null;
        }

        EmployerDomain.EmployerDomainBuilder employerDomain = EmployerDomain.builder();

        employerDomain.employeeDomain( employeeListToEmployeeDomainList( employer.getEmployee() ) );
        employerDomain.id( employer.getId() );
        employerDomain.name( employer.getName() );
        employerDomain.nip( employer.getNip() );
        employerDomain.address( addressEmployerMapper.mapToDomain( employer.getAddress() ) );

        return employerDomain.build();
    }

    @Override
    public Employer map(EmployerDomain employerDomain) {
        if ( employerDomain == null ) {
            return null;
        }

        Employer.EmployerBuilder employer = Employer.builder();

        employer.employee( employeeDomainListToEmployeeList( employerDomain.getEmployeeDomain() ) );
        employer.id( employerDomain.getId() );
        employer.name( employerDomain.getName() );
        employer.nip( employerDomain.getNip() );
        employer.address( addressEmployerDomainListToAddressList( employerDomain.getAddress() ) );

        return employer.build();
    }

    @Override
    public List<EmployerDomain> mapToDomain(List<Employer> employers) {
        if ( employers == null ) {
            return null;
        }

        List<EmployerDomain> list = new ArrayList<EmployerDomain>( employers.size() );
        for ( Employer employer : employers ) {
            list.add( map( employer ) );
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
        employeeDomain.nip( employee.getNip() );

        return employeeDomain.build();
    }

    protected List<EmployeeDomain> employeeListToEmployeeDomainList(List<Employee> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployeeDomain> list1 = new ArrayList<EmployeeDomain>( list.size() );
        for ( Employee employee : list ) {
            list1.add( employeeToEmployeeDomain( employee ) );
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
        employee.nip( employeeDomain.getNip() );

        return employee.build();
    }

    protected List<Employee> employeeDomainListToEmployeeList(List<EmployeeDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<Employee> list1 = new ArrayList<Employee>( list.size() );
        for ( EmployeeDomain employeeDomain : list ) {
            list1.add( employeeDomainToEmployee( employeeDomain ) );
        }

        return list1;
    }

    protected List<Address> addressEmployerDomainListToAddressList(List<AddressEmployerDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressEmployerDomain addressEmployerDomain : list ) {
            list1.add( addressEmployerMapper.map( addressEmployerDomain ) );
        }

        return list1;
    }
}
