package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.repository.EmployeeRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.EmployeeManagerMapper;

import java.util.List;

@Service
public class EmployeeManagerService implements CrudService<EmployeeManagerDomain, Integer> {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final EmployeeManagerMapper mapper = Mappers.getMapper(EmployeeManagerMapper.class);

    @Override
    public List<EmployeeManagerDomain> list() {
        return mapper.mapToDomain(employeeRepository.findAll());
    }

    @Override
    public EmployeeManagerDomain get(Integer integer) {
        return employeeRepository.findById(integer)
                .map(employee -> mapper.map(employee))
                .orElse(null);
    }

    @Override
    public EmployeeManagerDomain create(EmployeeManagerDomain employeeManagerDomain) {
        employeeManagerDomain.setId(null);
        Employee created = employeeRepository.save(mapper.map(employeeManagerDomain));
        return mapper.map(created);
    }

    @Override
    public EmployeeManagerDomain update(EmployeeManagerDomain employeeManagerDomain) {
        EmployeeManagerDomain existing = get(employeeManagerDomain.getId());
        if (existing == null) {
            return null;
        }

        Employee updated = employeeRepository.save(mapper.map(employeeManagerDomain));
        return mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        employeeRepository.deleteById(integer);
    }
}
