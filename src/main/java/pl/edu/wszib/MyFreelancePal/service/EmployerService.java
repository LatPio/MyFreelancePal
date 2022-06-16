package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.repository.EmployerRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.EmployerMapper;

import java.util.List;

@Service
public class EmployerService implements CrudService<EmployerDomain, Integer> {

    @Autowired
    private EmployerRepository employerRepository;

    private EmployerMapper mapper = Mappers.getMapper(EmployerMapper.class);

    @Override
    public List<EmployerDomain> list() {
        return mapper.mapToDomain(employerRepository.findAll());
    }

    @Override
    public EmployerDomain get(Integer integer) {
        return employerRepository.findById(integer)
                .map(employer -> mapper.map(employer))
                .orElse(null);
    }

    @Override
    public EmployerDomain create(EmployerDomain employerDomain) {
        employerDomain.setId(null);
        Employer created = employerRepository.save(mapper.map(employerDomain));
        return mapper.map(created);
    }

    @Override
    public EmployerDomain update(EmployerDomain employerDomain) {
        EmployerDomain existing = get(employerDomain.getId());
        if(existing == null){
        return null;}

        Employer updated = employerRepository.save(mapper.map(employerDomain));
        return mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        employerRepository.deleteById(integer);
    }
}
