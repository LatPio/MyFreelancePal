package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-06T19:12:12+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
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
}
