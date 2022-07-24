package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.repository.EmployerRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.EmployerManagerMapper;
import pl.edu.wszib.MyFreelancePal.service.mapper.EmployerMapper;

import java.util.List;

@Service
public class EmployerManagerService implements CrudService<EmployerManagerDomain, Integer> {

    @Autowired
    private EmployerRepository employerRepository;

    private EmployerManagerMapper mapper = Mappers.getMapper(EmployerManagerMapper.class);

    @Override
    public List<EmployerManagerDomain> list() {
        return mapper.mapToDomain(employerRepository.findAll());
    }

    public List<EmployerManagerDomain> findByActive(Boolean active) {return mapper.mapToDomain(employerRepository.findByActive(active));}

    @Override
    public EmployerManagerDomain get(Integer integer) {
        return employerRepository.findById(integer)
                .map(employer -> mapper.map(employer))
                .orElse(null);
    }

    @Override
    public EmployerManagerDomain create(EmployerManagerDomain employerManagerDomain) {
        employerManagerDomain.setId(null);
        Employer created = employerRepository.save(mapper.map(employerManagerDomain));
        return mapper.map(created);
    }

    @Override
    public EmployerManagerDomain update(EmployerManagerDomain employerManagerDomain) {
        EmployerManagerDomain existing = get(employerManagerDomain.getId());
        if(existing == null){
        return null;}

        Employer updated = employerRepository.save(mapper.map(employerManagerDomain));
        return mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        employerRepository.deleteById(integer);
    }
}
