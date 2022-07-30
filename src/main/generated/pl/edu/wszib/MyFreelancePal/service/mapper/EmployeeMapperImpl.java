package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-30T12:46:28+0200",
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

        return employeeDomain.build();
    }

    @Override
    public Employee map(EmployeeDomain employeeDomain) {
        if ( employeeDomain == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDomain.getId() );
        employee.setName( employeeDomain.getName() );

        return employee;
    }

    @Override
    public List<EmployeeDomain> mapToDomain(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDomain> list = new ArrayList<EmployeeDomain>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( map( employee ) );
        }

        return list;
    }
}
