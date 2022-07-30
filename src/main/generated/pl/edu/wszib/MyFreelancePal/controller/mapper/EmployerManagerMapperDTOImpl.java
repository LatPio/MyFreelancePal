package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.factory.Mappers;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-30T12:46:28+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployerManagerMapperDTOImpl implements EmployerManagerMapperDTO {

    private final ProjectMapperDTO projectMapperDTO = Mappers.getMapper( ProjectMapperDTO.class );

    @Override
    public EmployerManagerDTO map(EmployerManagerDomain employerManagerDomain) {
        if ( employerManagerDomain == null ) {
            return null;
        }

        EmployerManagerDTO employerManagerDTO = new EmployerManagerDTO();

        employerManagerDTO.setId( employerManagerDomain.getId() );
        employerManagerDTO.setName( employerManagerDomain.getName() );
        employerManagerDTO.setDescription( employerManagerDomain.getDescription() );
        employerManagerDTO.setNotes( employerManagerDomain.getNotes() );
        employerManagerDTO.setPhone( employerManagerDomain.getPhone() );
        employerManagerDTO.setEmail( employerManagerDomain.getEmail() );
        employerManagerDTO.setNip( employerManagerDomain.getNip() );
        employerManagerDTO.setActive( employerManagerDomain.getActive() );
        employerManagerDTO.setAddress( addressEmployerDomainListToAddressEmployerDTOList( employerManagerDomain.getAddress() ) );
        employerManagerDTO.setProjects( projectMapperDTO.mapToDTO( employerManagerDomain.getProjects() ) );

        return employerManagerDTO;
    }

    @Override
    public EmployerManagerDomain map(EmployerManagerDTO employerManagerDTO) {
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

    @Override
    public List<EmployerManagerDTO> mapToDTO(List<EmployerManagerDomain> employerManagerDomains) {
        if ( employerManagerDomains == null ) {
            return null;
        }

        List<EmployerManagerDTO> list = new ArrayList<EmployerManagerDTO>( employerManagerDomains.size() );
        for ( EmployerManagerDomain employerManagerDomain : employerManagerDomains ) {
            list.add( map( employerManagerDomain ) );
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

    protected List<ProjectDomain> projectDTOListToProjectDomainList(List<ProjectDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectDomain> list1 = new ArrayList<ProjectDomain>( list.size() );
        for ( ProjectDTO projectDTO : list ) {
            list1.add( projectMapperDTO.map( projectDTO ) );
        }

        return list1;
    }
}
