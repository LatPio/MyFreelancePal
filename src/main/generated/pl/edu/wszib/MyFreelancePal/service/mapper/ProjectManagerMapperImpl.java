package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectManagerDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-30T12:46:28+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProjectManagerMapperImpl implements ProjectManagerMapper {

    private final TaskMapper taskMapper = Mappers.getMapper( TaskMapper.class );

    @Override
    public ProjectManagerDomain map(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectManagerDomain.ProjectManagerDomainBuilder projectManagerDomain = ProjectManagerDomain.builder();

        projectManagerDomain.id( project.getId() );
        projectManagerDomain.name( project.getName() );
        projectManagerDomain.color( project.getColor() );
        projectManagerDomain.description( project.getDescription() );
        projectManagerDomain.activeProject( project.getActiveProject() );
        projectManagerDomain.hourPriceDefault( project.getHourPriceDefault() );
        projectManagerDomain.tasks( taskMapper.mapToDomain( project.getTasks() ) );
        projectManagerDomain.employer( employerToEmployerManagerDomain( project.getEmployer() ) );

        return projectManagerDomain.build();
    }

    @Override
    public Project map(ProjectManagerDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectDomain.getId() );
        project.setName( projectDomain.getName() );
        project.setColor( projectDomain.getColor() );
        project.setDescription( projectDomain.getDescription() );
        project.setActiveProject( projectDomain.getActiveProject() );
        project.setHourPriceDefault( projectDomain.getHourPriceDefault() );
        project.setTasks( taskMapper.mapToTasks( projectDomain.getTasks() ) );
        project.setEmployer( employerManagerDomainToEmployer( projectDomain.getEmployer() ) );

        return project;
    }

    @Override
    public List<ProjectManagerDomain> mapToDomain(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectManagerDomain> list = new ArrayList<ProjectManagerDomain>( projects.size() );
        for ( Project project : projects ) {
            list.add( map( project ) );
        }

        return list;
    }

    protected EmployerDomain employerToEmployerDomain(Employer employer) {
        if ( employer == null ) {
            return null;
        }

        EmployerDomain.EmployerDomainBuilder employerDomain = EmployerDomain.builder();

        employerDomain.id( employer.getId() );
        employerDomain.name( employer.getName() );

        return employerDomain.build();
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
        addressEmployerDomain.employer( employerToEmployerDomain( address.getEmployer() ) );

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

    protected ProjectDomain projectToProjectDomain(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDomain.ProjectDomainBuilder projectDomain = ProjectDomain.builder();

        projectDomain.id( project.getId() );
        projectDomain.name( project.getName() );
        projectDomain.color( project.getColor() );
        projectDomain.hourPriceDefault( project.getHourPriceDefault() );

        return projectDomain.build();
    }

    protected List<ProjectDomain> projectListToProjectDomainList(List<Project> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectDomain> list1 = new ArrayList<ProjectDomain>( list.size() );
        for ( Project project : list ) {
            list1.add( projectToProjectDomain( project ) );
        }

        return list1;
    }

    protected EmployerManagerDomain employerToEmployerManagerDomain(Employer employer) {
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
        employerManagerDomain.address( addressListToAddressEmployerDomainList( employer.getAddress() ) );
        employerManagerDomain.projects( projectListToProjectDomainList( employer.getProjects() ) );

        return employerManagerDomain.build();
    }

    protected Employer employerDomainToEmployer(EmployerDomain employerDomain) {
        if ( employerDomain == null ) {
            return null;
        }

        Employer employer = new Employer();

        employer.setId( employerDomain.getId() );
        employer.setName( employerDomain.getName() );

        return employer;
    }

    protected Address addressEmployerDomainToAddress(AddressEmployerDomain addressEmployerDomain) {
        if ( addressEmployerDomain == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressEmployerDomain.getId() );
        address.setName( addressEmployerDomain.getName() );
        address.setStreet( addressEmployerDomain.getStreet() );
        address.setPostalCode( addressEmployerDomain.getPostalCode() );
        address.setBuildingNumber( addressEmployerDomain.getBuildingNumber() );
        address.setFlatNumber( addressEmployerDomain.getFlatNumber() );
        address.setCity( addressEmployerDomain.getCity() );
        address.setCountry( addressEmployerDomain.getCountry() );
        address.setEmployer( employerDomainToEmployer( addressEmployerDomain.getEmployer() ) );

        return address;
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

    protected Project projectDomainToProject(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectDomain.getId() );
        project.setName( projectDomain.getName() );
        project.setColor( projectDomain.getColor() );
        project.setHourPriceDefault( projectDomain.getHourPriceDefault() );

        return project;
    }

    protected List<Project> projectDomainListToProjectList(List<ProjectDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<Project> list1 = new ArrayList<Project>( list.size() );
        for ( ProjectDomain projectDomain : list ) {
            list1.add( projectDomainToProject( projectDomain ) );
        }

        return list1;
    }

    protected Employer employerManagerDomainToEmployer(EmployerManagerDomain employerManagerDomain) {
        if ( employerManagerDomain == null ) {
            return null;
        }

        Employer employer = new Employer();

        employer.setId( employerManagerDomain.getId() );
        employer.setName( employerManagerDomain.getName() );
        employer.setDescription( employerManagerDomain.getDescription() );
        employer.setNotes( employerManagerDomain.getNotes() );
        employer.setNip( employerManagerDomain.getNip() );
        employer.setPhone( employerManagerDomain.getPhone() );
        employer.setEmail( employerManagerDomain.getEmail() );
        employer.setActive( employerManagerDomain.getActive() );
        employer.setAddress( addressEmployerDomainListToAddressList( employerManagerDomain.getAddress() ) );
        employer.setProjects( projectDomainListToProjectList( employerManagerDomain.getProjects() ) );

        return employer;
    }
}
