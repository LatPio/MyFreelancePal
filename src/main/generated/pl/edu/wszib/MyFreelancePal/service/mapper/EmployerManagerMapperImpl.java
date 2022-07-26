package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-26T12:11:45+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployerManagerMapperImpl implements EmployerManagerMapper {

    private final ProjectMapper projectMapper = Mappers.getMapper( ProjectMapper.class );
    private final AddressEmployerMapper addressEmployerMapper = Mappers.getMapper( AddressEmployerMapper.class );

    @Override
    public EmployerManagerDomain map(Employer employer) {
        if ( employer == null ) {
            return null;
        }

        EmployerManagerDomain.EmployerManagerDomainBuilder employerManagerDomain = EmployerManagerDomain.builder();

        employerManagerDomain.id( employer.getId() );
        employerManagerDomain.name( employer.getName() );
        employerManagerDomain.description( employer.getDescription() );
        employerManagerDomain.notes( employer.getNotes() );
        employerManagerDomain.phone( employer.getPhone() );
        employerManagerDomain.email( employer.getEmail() );
        employerManagerDomain.nip( employer.getNip() );
        employerManagerDomain.active( employer.getActive() );
        employerManagerDomain.address( addressEmployerMapper.mapToDomain( employer.getAddress() ) );
        employerManagerDomain.projects( projectMapper.mapToDomain( employer.getProjects() ) );

        return employerManagerDomain.build();
    }

    @Override
    public Employer map(EmployerManagerDomain employerManagerDomain) {
        if ( employerManagerDomain == null ) {
            return null;
        }

        Employer.EmployerBuilder employer = Employer.builder();

        employer.id( employerManagerDomain.getId() );
        employer.name( employerManagerDomain.getName() );
        employer.description( employerManagerDomain.getDescription() );
        employer.notes( employerManagerDomain.getNotes() );
        employer.nip( employerManagerDomain.getNip() );
        employer.phone( employerManagerDomain.getPhone() );
        employer.email( employerManagerDomain.getEmail() );
        employer.active( employerManagerDomain.getActive() );
        employer.address( addressEmployerDomainListToAddressList( employerManagerDomain.getAddress() ) );
        employer.projects( projectDomainListToProjectList( employerManagerDomain.getProjects() ) );

        return employer.build();
    }

    @Override
    public List<EmployerManagerDomain> mapToDomain(List<Employer> employers) {
        if ( employers == null ) {
            return null;
        }

        List<EmployerManagerDomain> list = new ArrayList<EmployerManagerDomain>( employers.size() );
        for ( Employer employer : employers ) {
            list.add( map( employer ) );
        }

        return list;
    }

    protected List<Address> addressEmployerDomainListToAddressList(List<AddressEmployerDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressEmployerDomain addressEmployerDomain : list ) {
            list1.add( addressEmployerMapper.map( addressEmployerDomain ) );
        }

        return list1;
    }

    protected List<Project> projectDomainListToProjectList(List<ProjectDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<Project> list1 = new ArrayList<Project>( list.size() );
        for ( ProjectDomain projectDomain : list ) {
            list1.add( projectMapper.map( projectDomain ) );
        }

        return list1;
    }
}
