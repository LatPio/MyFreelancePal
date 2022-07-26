package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectManagerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectManagerDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-26T12:24:06+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProjectManagerMapperDTOImpl implements ProjectManagerMapperDTO {

    private final TaskMapperDTO taskMapperDTO = Mappers.getMapper( TaskMapperDTO.class );

    @Override
    public ProjectManagerDTO map(ProjectManagerDomain projectManagerDomain) {
        if ( projectManagerDomain == null ) {
            return null;
        }

        ProjectManagerDTO.ProjectManagerDTOBuilder projectManagerDTO = ProjectManagerDTO.builder();

        projectManagerDTO.id( projectManagerDomain.getId() );
        projectManagerDTO.name( projectManagerDomain.getName() );
        projectManagerDTO.color( projectManagerDomain.getColor() );
        projectManagerDTO.description( projectManagerDomain.getDescription() );
        projectManagerDTO.activeProject( projectManagerDomain.getActiveProject() );
        projectManagerDTO.hourPriceDefault( projectManagerDomain.getHourPriceDefault() );
        projectManagerDTO.tasks( taskMapperDTO.mapToDTO( projectManagerDomain.getTasks() ) );
        projectManagerDTO.employer( employerManagerDomainToEmployerManagerDTO( projectManagerDomain.getEmployer() ) );

        return projectManagerDTO.build();
    }

    @Override
    public ProjectManagerDomain map(ProjectManagerDTO projectManagerDTO) {
        if ( projectManagerDTO == null ) {
            return null;
        }

        ProjectManagerDomain.ProjectManagerDomainBuilder projectManagerDomain = ProjectManagerDomain.builder();

        projectManagerDomain.id( projectManagerDTO.getId() );
        projectManagerDomain.name( projectManagerDTO.getName() );
        projectManagerDomain.color( projectManagerDTO.getColor() );
        projectManagerDomain.description( projectManagerDTO.getDescription() );
        projectManagerDomain.activeProject( projectManagerDTO.getActiveProject() );
        projectManagerDomain.hourPriceDefault( projectManagerDTO.getHourPriceDefault() );
        projectManagerDomain.tasks( taskMapperDTO.mapToDomain( projectManagerDTO.getTasks() ) );
        projectManagerDomain.employer( employerManagerDTOToEmployerManagerDomain( projectManagerDTO.getEmployer() ) );

        return projectManagerDomain.build();
    }

    @Override
    public List<ProjectManagerDTO> mapToDTO(List<ProjectManagerDomain> projectManagerDomain) {
        if ( projectManagerDomain == null ) {
            return null;
        }

        List<ProjectManagerDTO> list = new ArrayList<ProjectManagerDTO>( projectManagerDomain.size() );
        for ( ProjectManagerDomain projectManagerDomain1 : projectManagerDomain ) {
            list.add( map( projectManagerDomain1 ) );
        }

        return list;
    }

    protected EmployerDTO employerDomainToEmployerDTO(EmployerDomain employerDomain) {
        if ( employerDomain == null ) {
            return null;
        }

        EmployerDTO.EmployerDTOBuilder employerDTO = EmployerDTO.builder();

        employerDTO.id( employerDomain.getId() );
        employerDTO.name( employerDomain.getName() );

        return employerDTO.build();
    }

    protected AddressEmployerDTO addressEmployerDomainToAddressEmployerDTO(AddressEmployerDomain addressEmployerDomain) {
        if ( addressEmployerDomain == null ) {
            return null;
        }

        AddressEmployerDTO.AddressEmployerDTOBuilder addressEmployerDTO = AddressEmployerDTO.builder();

        addressEmployerDTO.id( addressEmployerDomain.getId() );
        addressEmployerDTO.name( addressEmployerDomain.getName() );
        addressEmployerDTO.street( addressEmployerDomain.getStreet() );
        addressEmployerDTO.postalCode( addressEmployerDomain.getPostalCode() );
        addressEmployerDTO.buildingNumber( addressEmployerDomain.getBuildingNumber() );
        addressEmployerDTO.flatNumber( addressEmployerDomain.getFlatNumber() );
        addressEmployerDTO.city( addressEmployerDomain.getCity() );
        addressEmployerDTO.country( addressEmployerDomain.getCountry() );
        addressEmployerDTO.employer( employerDomainToEmployerDTO( addressEmployerDomain.getEmployer() ) );

        return addressEmployerDTO.build();
    }

    protected List<AddressEmployerDTO> addressEmployerDomainListToAddressEmployerDTOList(List<AddressEmployerDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressEmployerDTO> list1 = new ArrayList<AddressEmployerDTO>( list.size() );
        for ( AddressEmployerDomain addressEmployerDomain : list ) {
            list1.add( addressEmployerDomainToAddressEmployerDTO( addressEmployerDomain ) );
        }

        return list1;
    }

    protected ProjectDTO projectDomainToProjectDTO(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        ProjectDTO.ProjectDTOBuilder projectDTO = ProjectDTO.builder();

        projectDTO.id( projectDomain.getId() );
        projectDTO.name( projectDomain.getName() );
        projectDTO.hourPriceDefault( projectDomain.getHourPriceDefault() );

        return projectDTO.build();
    }

    protected List<ProjectDTO> projectDomainListToProjectDTOList(List<ProjectDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectDTO> list1 = new ArrayList<ProjectDTO>( list.size() );
        for ( ProjectDomain projectDomain : list ) {
            list1.add( projectDomainToProjectDTO( projectDomain ) );
        }

        return list1;
    }

    protected EmployerManagerDTO employerManagerDomainToEmployerManagerDTO(EmployerManagerDomain employerManagerDomain) {
        if ( employerManagerDomain == null ) {
            return null;
        }

        EmployerManagerDTO.EmployerManagerDTOBuilder employerManagerDTO = EmployerManagerDTO.builder();

        employerManagerDTO.id( employerManagerDomain.getId() );
        employerManagerDTO.name( employerManagerDomain.getName() );
        employerManagerDTO.description( employerManagerDomain.getDescription() );
        employerManagerDTO.notes( employerManagerDomain.getNotes() );
        employerManagerDTO.phone( employerManagerDomain.getPhone() );
        employerManagerDTO.email( employerManagerDomain.getEmail() );
        employerManagerDTO.nip( employerManagerDomain.getNip() );
        employerManagerDTO.active( employerManagerDomain.getActive() );
        employerManagerDTO.address( addressEmployerDomainListToAddressEmployerDTOList( employerManagerDomain.getAddress() ) );
        employerManagerDTO.projects( projectDomainListToProjectDTOList( employerManagerDomain.getProjects() ) );

        return employerManagerDTO.build();
    }

    protected EmployerDomain employerDTOToEmployerDomain(EmployerDTO employerDTO) {
        if ( employerDTO == null ) {
            return null;
        }

        EmployerDomain.EmployerDomainBuilder employerDomain = EmployerDomain.builder();

        employerDomain.id( employerDTO.getId() );
        employerDomain.name( employerDTO.getName() );

        return employerDomain.build();
    }

    protected AddressEmployerDomain addressEmployerDTOToAddressEmployerDomain(AddressEmployerDTO addressEmployerDTO) {
        if ( addressEmployerDTO == null ) {
            return null;
        }

        AddressEmployerDomain.AddressEmployerDomainBuilder addressEmployerDomain = AddressEmployerDomain.builder();

        addressEmployerDomain.id( addressEmployerDTO.getId() );
        addressEmployerDomain.name( addressEmployerDTO.getName() );
        addressEmployerDomain.street( addressEmployerDTO.getStreet() );
        addressEmployerDomain.postalCode( addressEmployerDTO.getPostalCode() );
        addressEmployerDomain.buildingNumber( addressEmployerDTO.getBuildingNumber() );
        addressEmployerDomain.flatNumber( addressEmployerDTO.getFlatNumber() );
        addressEmployerDomain.city( addressEmployerDTO.getCity() );
        addressEmployerDomain.country( addressEmployerDTO.getCountry() );
        addressEmployerDomain.employer( employerDTOToEmployerDomain( addressEmployerDTO.getEmployer() ) );

        return addressEmployerDomain.build();
    }

    protected List<AddressEmployerDomain> addressEmployerDTOListToAddressEmployerDomainList(List<AddressEmployerDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressEmployerDomain> list1 = new ArrayList<AddressEmployerDomain>( list.size() );
        for ( AddressEmployerDTO addressEmployerDTO : list ) {
            list1.add( addressEmployerDTOToAddressEmployerDomain( addressEmployerDTO ) );
        }

        return list1;
    }

    protected ProjectDomain projectDTOToProjectDomain(ProjectDTO projectDTO) {
        if ( projectDTO == null ) {
            return null;
        }

        ProjectDomain.ProjectDomainBuilder projectDomain = ProjectDomain.builder();

        projectDomain.id( projectDTO.getId() );
        projectDomain.name( projectDTO.getName() );
        projectDomain.hourPriceDefault( projectDTO.getHourPriceDefault() );

        return projectDomain.build();
    }

    protected List<ProjectDomain> projectDTOListToProjectDomainList(List<ProjectDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectDomain> list1 = new ArrayList<ProjectDomain>( list.size() );
        for ( ProjectDTO projectDTO : list ) {
            list1.add( projectDTOToProjectDomain( projectDTO ) );
        }

        return list1;
    }

    protected EmployerManagerDomain employerManagerDTOToEmployerManagerDomain(EmployerManagerDTO employerManagerDTO) {
        if ( employerManagerDTO == null ) {
            return null;
        }

        EmployerManagerDomain.EmployerManagerDomainBuilder employerManagerDomain = EmployerManagerDomain.builder();

        employerManagerDomain.id( employerManagerDTO.getId() );
        employerManagerDomain.name( employerManagerDTO.getName() );
        employerManagerDomain.description( employerManagerDTO.getDescription() );
        employerManagerDomain.notes( employerManagerDTO.getNotes() );
        employerManagerDomain.phone( employerManagerDTO.getPhone() );
        employerManagerDomain.email( employerManagerDTO.getEmail() );
        employerManagerDomain.nip( employerManagerDTO.getNip() );
        employerManagerDomain.active( employerManagerDTO.getActive() );
        employerManagerDomain.address( addressEmployerDTOListToAddressEmployerDomainList( employerManagerDTO.getAddress() ) );
        employerManagerDomain.projects( projectDTOListToProjectDomainList( employerManagerDTO.getProjects() ) );

        return employerManagerDomain.build();
    }
}
