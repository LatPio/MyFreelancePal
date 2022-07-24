package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeManagerDomain;


import java.util.List;

@Mapper(uses = {EmployerMapper.class})
public interface EmployeeManagerMapper {

    EmployeeManagerDomain map(Employee employee);
    Employee map (EmployeeManagerDomain employeeManagerDomain);
    List<EmployeeManagerDomain> mapToDomain(List<Employee> employee);
}
