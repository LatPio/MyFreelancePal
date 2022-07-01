package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-01T19:26:51+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDomain map(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDomain.ProjectDomainBuilder projectDomain = ProjectDomain.builder();

        projectDomain.employerDomain( employerToEmployerDomain( project.getEmployer() ) );
        projectDomain.id( project.getId() );
        projectDomain.name( project.getName() );

        return projectDomain.build();
    }

    @Override
    public Project map(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.employer( employerDomainToEmployer( projectDomain.getEmployerDomain() ) );
        project.id( projectDomain.getId() );
        project.name( projectDomain.getName() );

        return project.build();
    }

    @Override
    public List<ProjectDomain> mapToDomain(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectDomain> list = new ArrayList<ProjectDomain>( projects.size() );
        for ( Project project : projects ) {
            list.add( map( project ) );
        }

        return list;
    }

    protected AddressEmployerDomain addressToAddressEmployerDomain(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEmployerDomain.AddressEmployerDomainBuilder addressEmployerDomain = AddressEmployerDomain.builder();

        addressEmployerDomain.id( address.getId() );
        addressEmployerDomain.name( address.getName() );
        addressEmployerDomain.street( address.getStreet() );
        addressEmployerDomain.postalCode( address.getPostalCode() );
        addressEmployerDomain.buildingNumber( address.getBuildingNumber() );
        addressEmployerDomain.flatNumber( address.getFlatNumber() );
        addressEmployerDomain.city( address.getCity() );
        addressEmployerDomain.country( address.getCountry() );

        return addressEmployerDomain.build();
    }

    protected List<AddressEmployerDomain> addressListToAddressEmployerDomainList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressEmployerDomain> list1 = new ArrayList<AddressEmployerDomain>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressEmployerDomain( address ) );
        }

        return list1;
    }

    protected EmployerDomain employerToEmployerDomain(Employer employer) {
        if ( employer == null ) {
            return null;
        }

        EmployerDomain.EmployerDomainBuilder employerDomain = EmployerDomain.builder();

        employerDomain.id( employer.getId() );
        employerDomain.name( employer.getName() );
        employerDomain.nip( employer.getNip() );
        employerDomain.address( addressListToAddressEmployerDomainList( employer.getAddress() ) );

        return employerDomain.build();
    }

    protected Address addressEmployerDomainToAddress(AddressEmployerDomain addressEmployerDomain) {
        if ( addressEmployerDomain == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.id( addressEmployerDomain.getId() );
        address.name( addressEmployerDomain.getName() );
        address.street( addressEmployerDomain.getStreet() );
        address.postalCode( addressEmployerDomain.getPostalCode() );
        address.buildingNumber( addressEmployerDomain.getBuildingNumber() );
        address.flatNumber( addressEmployerDomain.getFlatNumber() );
        address.city( addressEmployerDomain.getCity() );
        address.country( addressEmployerDomain.getCountry() );

        return address.build();
    }

    protected List<Address> addressEmployerDomainListToAddressList(List<AddressEmployerDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressEmployerDomain addressEmployerDomain : list ) {
            list1.add( addressEmployerDomainToAddress( addressEmployerDomain ) );
        }

        return list1;
    }

    protected Employer employerDomainToEmployer(EmployerDomain employerDomain) {
        if ( employerDomain == null ) {
            return null;
        }

        Employer.EmployerBuilder employer = Employer.builder();

        employer.id( employerDomain.getId() );
        employer.name( employerDomain.getName() );
        employer.nip( employerDomain.getNip() );
        employer.address( addressEmployerDomainListToAddressList( employerDomain.getAddress() ) );

        return employer.build();
    }
}
