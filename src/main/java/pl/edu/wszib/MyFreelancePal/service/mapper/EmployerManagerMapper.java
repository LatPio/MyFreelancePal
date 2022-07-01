package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;

import java.util.List;

@Mapper(uses = {ProjectMapper.class, AddressEmployerMapper.class} )
public interface EmployerManagerMapper {


    EmployerManagerDomain map(Employer employer);

    Employer map (EmployerManagerDomain employerManagerDomain);

    List<EmployerManagerDomain> mapToDomain(List<Employer> employers);
}
