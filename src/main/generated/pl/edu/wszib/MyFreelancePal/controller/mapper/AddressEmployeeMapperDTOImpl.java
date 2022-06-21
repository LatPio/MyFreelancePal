package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-21T23:06:25+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class AddressEmployeeMapperDTOImpl implements AddressEmployeeMapperDTO {

    @Override
    public AddressEmployeeDTO map(AddressEmployeeDomain addressEmployeeDomain) {
        if ( addressEmployeeDomain == null ) {
            return null;
        }

        AddressEmployeeDTO.AddressEmployeeDTOBuilder addressEmployeeDTO = AddressEmployeeDTO.builder();

        addressEmployeeDTO.employeeDTO( employeeDomainListToEmployeeDTOList( addressEmployeeDomain.getEmployeeDomain() ) );
        addressEmployeeDTO.id( addressEmployeeDomain.getId() );
        addressEmployeeDTO.name( addressEmployeeDomain.getName() );
        addressEmployeeDTO.street( addressEmployeeDomain.getStreet() );
        addressEmployeeDTO.postalCode( addressEmployeeDomain.getPostalCode() );
        addressEmployeeDTO.buildingNumber( addressEmployeeDomain.getBuildingNumber() );
        addressEmployeeDTO.flatNumber( addressEmployeeDomain.getFlatNumber() );
        addressEmployeeDTO.city( addressEmployeeDomain.getCity() );
        addressEmployeeDTO.country( addressEmployeeDomain.getCountry() );

        return addressEmployeeDTO.build();
    }

    @Override
    public AddressEmployeeDomain map(AddressEmployeeDTO addressEmployeeDTO) {
        if ( addressEmployeeDTO == null ) {
            return null;
        }

        AddressEmployeeDomain.AddressEmployeeDomainBuilder addressEmployeeDomain = AddressEmployeeDomain.builder();

        addressEmployeeDomain.employeeDomain( employeeDTOListToEmployeeDomainList( addressEmployeeDTO.getEmployeeDTO() ) );
        addressEmployeeDomain.id( addressEmployeeDTO.getId() );
        addressEmployeeDomain.name( addressEmployeeDTO.getName() );
        addressEmployeeDomain.street( addressEmployeeDTO.getStreet() );
        addressEmployeeDomain.postalCode( addressEmployeeDTO.getPostalCode() );
        addressEmployeeDomain.buildingNumber( addressEmployeeDTO.getBuildingNumber() );
        addressEmployeeDomain.flatNumber( addressEmployeeDTO.getFlatNumber() );
        addressEmployeeDomain.city( addressEmployeeDTO.getCity() );
        addressEmployeeDomain.country( addressEmployeeDTO.getCountry() );

        return addressEmployeeDomain.build();
    }

    @Override
    public List<AddressEmployeeDTO> mapToDTO(List<AddressEmployeeDomain> addressEmployeeDomains) {
        if ( addressEmployeeDomains == null ) {
            return null;
        }

        List<AddressEmployeeDTO> list = new ArrayList<AddressEmployeeDTO>( addressEmployeeDomains.size() );
        for ( AddressEmployeeDomain addressEmployeeDomain : addressEmployeeDomains ) {
            list.add( map( addressEmployeeDomain ) );
        }

        return list;
    }

    protected EmployeeDTO employeeDomainToEmployeeDTO(EmployeeDomain employeeDomain) {
        if ( employeeDomain == null ) {
            return null;
        }

        EmployeeDTO.EmployeeDTOBuilder employeeDTO = EmployeeDTO.builder();

        employeeDTO.id( employeeDomain.getId() );
        employeeDTO.name( employeeDomain.getName() );
        employeeDTO.nip( employeeDomain.getNip() );

        return employeeDTO.build();
    }

    protected List<EmployeeDTO> employeeDomainListToEmployeeDTOList(List<EmployeeDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployeeDTO> list1 = new ArrayList<EmployeeDTO>( list.size() );
        for ( EmployeeDomain employeeDomain : list ) {
            list1.add( employeeDomainToEmployeeDTO( employeeDomain ) );
        }

        return list1;
    }

    protected EmployeeDomain employeeDTOToEmployeeDomain(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        EmployeeDomain.EmployeeDomainBuilder employeeDomain = EmployeeDomain.builder();

        employeeDomain.id( employeeDTO.getId() );
        employeeDomain.name( employeeDTO.getName() );
        employeeDomain.nip( employeeDTO.getNip() );

        return employeeDomain.build();
    }

    protected List<EmployeeDomain> employeeDTOListToEmployeeDomainList(List<EmployeeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployeeDomain> list1 = new ArrayList<EmployeeDomain>( list.size() );
        for ( EmployeeDTO employeeDTO : list ) {
            list1.add( employeeDTOToEmployeeDomain( employeeDTO ) );
        }

        return list1;
    }
}
