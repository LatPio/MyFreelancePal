package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;


import java.util.List;

@Mapper(uses = {EmployerMapper.class})
public interface EmployeeMapper {

    EmployeeDomain map(Employee employee);

    Employee map (EmployeeDomain employeeDomain);

    List<EmployeeDomain> mapToDomain(List<Employee> employee);
}
