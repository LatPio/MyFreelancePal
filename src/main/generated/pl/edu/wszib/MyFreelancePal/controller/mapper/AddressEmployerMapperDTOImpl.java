package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-22T15:17:52+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class AddressEmployerMapperDTOImpl implements AddressEmployerMapperDTO {

    @Override
    public AddressEmployerDTO map(AddressEmployerDomain addressEmployerDomain) {
        if ( addressEmployerDomain == null ) {
            return null;
        }

        AddressEmployerDTO.AddressEmployerDTOBuilder addressEmployerDTO = AddressEmployerDTO.builder();

        addressEmployerDTO.employerDTO( employerDomainListToEmployerDTOList( addressEmployerDomain.getEmployerDomain() ) );
        addressEmployerDTO.id( addressEmployerDomain.getId() );
        addressEmployerDTO.name( addressEmployerDomain.getName() );
        addressEmployerDTO.street( addressEmployerDomain.getStreet() );
        addressEmployerDTO.postalCode( addressEmployerDomain.getPostalCode() );
        addressEmployerDTO.buildingNumber( addressEmployerDomain.getBuildingNumber() );
        addressEmployerDTO.flatNumber( addressEmployerDomain.getFlatNumber() );
        addressEmployerDTO.city( addressEmployerDomain.getCity() );
        addressEmployerDTO.country( addressEmployerDomain.getCountry() );

        return addressEmployerDTO.build();
    }

    @Override
    public AddressEmployerDomain map(AddressEmployerDTO addressEmployerDTO) {
        if ( addressEmployerDTO == null ) {
            return null;
        }

        AddressEmployerDomain.AddressEmployerDomainBuilder addressEmployerDomain = AddressEmployerDomain.builder();

        addressEmployerDomain.employerDomain( employerDTOListToEmployerDomainList( addressEmployerDTO.getEmployerDTO() ) );
        addressEmployerDomain.id( addressEmployerDTO.getId() );
        addressEmployerDomain.name( addressEmployerDTO.getName() );
        addressEmployerDomain.street( addressEmployerDTO.getStreet() );
        addressEmployerDomain.postalCode( addressEmployerDTO.getPostalCode() );
        addressEmployerDomain.buildingNumber( addressEmployerDTO.getBuildingNumber() );
        addressEmployerDomain.flatNumber( addressEmployerDTO.getFlatNumber() );
        addressEmployerDomain.city( addressEmployerDTO.getCity() );
        addressEmployerDomain.country( addressEmployerDTO.getCountry() );

        return addressEmployerDomain.build();
    }

    @Override
    public List<AddressEmployerDTO> mapToDTO(List<AddressEmployerDomain> addressEmployerDomains) {
        if ( addressEmployerDomains == null ) {
            return null;
        }

        List<AddressEmployerDTO> list = new ArrayList<AddressEmployerDTO>( addressEmployerDomains.size() );
        for ( AddressEmployerDomain addressEmployerDomain : addressEmployerDomains ) {
            list.add( map( addressEmployerDomain ) );
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
        employerDTO.nip( employerDomain.getNip() );

        return employerDTO.build();
    }

    protected List<EmployerDTO> employerDomainListToEmployerDTOList(List<EmployerDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployerDTO> list1 = new ArrayList<EmployerDTO>( list.size() );
        for ( EmployerDomain employerDomain : list ) {
            list1.add( employerDomainToEmployerDTO( employerDomain ) );
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
        employerDomain.nip( employerDTO.getNip() );

        return employerDomain.build();
    }

    protected List<EmployerDomain> employerDTOListToEmployerDomainList(List<EmployerDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployerDomain> list1 = new ArrayList<EmployerDomain>( list.size() );
        for ( EmployerDTO employerDTO : list ) {
            list1.add( employerDTOToEmployerDomain( employerDTO ) );
        }

        return list1;
    }
}
