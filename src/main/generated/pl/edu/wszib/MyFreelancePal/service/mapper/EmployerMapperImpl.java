package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-17T10:51:38+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployerMapperImpl implements EmployerMapper {

    @Override
    public EmployerDomain map(Employer employer) {
        if ( employer == null ) {
            return null;
        }

        EmployerDomain.EmployerDomainBuilder employerDomain = EmployerDomain.builder();

        employerDomain.id( employer.getId() );
        employerDomain.name( employer.getName() );
        employerDomain.nip( employer.getNip() );

        return employerDomain.build();
    }

    @Override
    public Employer map(EmployerDomain employerDomain) {
        if ( employerDomain == null ) {
            return null;
        }

        Employer.EmployerBuilder employer = Employer.builder();

        employer.id( employerDomain.getId() );
        employer.name( employerDomain.getName() );
        employer.nip( employerDomain.getNip() );

        return employer.build();
    }

    @Override
    public List<EmployerDomain> mapToDomain(List<Employer> employers) {
        if ( employers == null ) {
            return null;
        }

        List<EmployerDomain> list = new ArrayList<EmployerDomain>( employers.size() );
        for ( Employer employer : employers ) {
            list.add( map( employer ) );
        }

        return list;
    }
}
