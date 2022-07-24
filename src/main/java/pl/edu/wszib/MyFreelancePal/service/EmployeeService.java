package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.repository.EmployeeRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.EmployeeMapper;

import java.util.List;

@Service
public class EmployeeService implements CrudService<EmployeeDomain, Integer> {

    @Autowired
    private EmployeeRepository employeeRepository;

    private EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);
    @Override
    public List<EmployeeDomain> list() {
        return mapper.mapToDomain(employeeRepository.findAll());
    }

    @Override
    public EmployeeDomain get(Integer integer) {
        return employeeRepository.findById(integer).map(employee -> mapper.map(employee)).orElse(null);
    }

    @Override
    public EmployeeDomain create(EmployeeDomain employeeDomain) {
        employeeDomain.setId(null);
        Employee created = employeeRepository.save(mapper.map(employeeDomain));
        return mapper.map(created);
    }

    @Override
    public EmployeeDomain update(EmployeeDomain employeeDomain) {
        EmployeeDomain existing = get(employeeDomain.getId());
        if(existing ==null){
            return  null;
        }
        Employee updated = employeeRepository.save(mapper.map(employeeDomain));
        return mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) { employeeRepository.deleteById(integer);

    }
}
