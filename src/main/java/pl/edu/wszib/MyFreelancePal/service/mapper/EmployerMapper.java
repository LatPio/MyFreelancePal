package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

import java.util.List;

@Mapper(uses = {ProjectMapper.class, AddressEmployerMapper.class} )
public interface EmployerMapper {


    EmployerDomain map(Employer employer);

    Employer map (EmployerDomain employerDomain);

    List<EmployerDomain> mapToDomain(List<Employer> employers);
}
