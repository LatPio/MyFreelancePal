package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;

import java.util.List;

@Mapper(uses = {ProjectMapper.class, AddressEmployerMapper.class} )
public interface EmployerManagerMapper {

    @Mapping(source = "employee", target = "employeeDomain")
    EmployerManagerDomain map(Employer employer);
    @Mapping(source = "employeeDomain", target = "employee")
    Employer map (EmployerManagerDomain employerManagerDomain);

    List<EmployerManagerDomain> mapToDomain(List<Employer> employers);
}
