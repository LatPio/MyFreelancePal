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
    date = "2022-07-17T10:51:36+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployeeMapperDTOImpl implements EmployeeMapperDTO {

    @Override
    public EmployeeDTO map(EmployeeDomain employeeDomain) {
        if ( employeeDomain == null ) {
            return null;
        }

        EmployeeDTO.EmployeeDTOBuilder employeeDTO = EmployeeDTO.builder();

        employeeDTO.id( employeeDomain.getId() );
        employeeDTO.name( employeeDomain.getName() );
        employeeDTO.nip( employeeDomain.getNip() );
        employeeDTO.bankNumber( employeeDomain.getBankNumber() );
        employeeDTO.bankIban( employeeDomain.getBankIban() );
        employeeDTO.address( addressEmployeeDomainListToAddressEmployeeDTOList( employeeDomain.getAddress() ) );

        return employeeDTO.build();
    }

    @Override
    public EmployeeDomain map(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        EmployeeDomain.EmployeeDomainBuilder employeeDomain = EmployeeDomain.builder();

        employeeDomain.id( employeeDTO.getId() );
        employeeDomain.name( employeeDTO.getName() );
        employeeDomain.nip( employeeDTO.getNip() );
        employeeDomain.bankNumber( employeeDTO.getBankNumber() );
        employeeDomain.bankIban( employeeDTO.getBankIban() );
        employeeDomain.address( addressEmployeeDTOListToAddressEmployeeDomainList( employeeDTO.getAddress() ) );

        return employeeDomain.build();
    }

    @Override
    public List<EmployeeDTO> mapToDTO(List<EmployeeDomain> employeeDomains) {
        if ( employeeDomains == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( employeeDomains.size() );
        for ( EmployeeDomain employeeDomain : employeeDomains ) {
            list.add( map( employeeDomain ) );
        }

        return list;
    }

    protected AddressEmployeeDTO addressEmployeeDomainToAddressEmployeeDTO(AddressEmployeeDomain addressEmployeeDomain) {
        if ( addressEmployeeDomain == null ) {
            return null;
        }

        AddressEmployeeDTO.AddressEmployeeDTOBuilder addressEmployeeDTO = AddressEmployeeDTO.builder();

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

    protected List<AddressEmployeeDTO> addressEmployeeDomainListToAddressEmployeeDTOList(List<AddressEmployeeDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressEmployeeDTO> list1 = new ArrayList<AddressEmployeeDTO>( list.size() );
        for ( AddressEmployeeDomain addressEmployeeDomain : list ) {
            list1.add( addressEmployeeDomainToAddressEmployeeDTO( addressEmployeeDomain ) );
        }

        return list1;
    }

    protected AddressEmployeeDomain addressEmployeeDTOToAddressEmployeeDomain(AddressEmployeeDTO addressEmployeeDTO) {
        if ( addressEmployeeDTO == null ) {
            return null;
        }

        AddressEmployeeDomain.AddressEmployeeDomainBuilder addressEmployeeDomain = AddressEmployeeDomain.builder();

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

    protected List<AddressEmployeeDomain> addressEmployeeDTOListToAddressEmployeeDomainList(List<AddressEmployeeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressEmployeeDomain> list1 = new ArrayList<AddressEmployeeDomain>( list.size() );
        for ( AddressEmployeeDTO addressEmployeeDTO : list ) {
            list1.add( addressEmployeeDTOToAddressEmployeeDomain( addressEmployeeDTO ) );
        }

        return list1;
    }
}
