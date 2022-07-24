package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeManagerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeManagerDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T20:44:31+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployeeManagerMapperDTOImpl implements EmployeeManagerMapperDTO {

    @Override
    public EmployeeManagerDTO map(EmployeeManagerDomain employeeManagerDomain) {
        if ( employeeManagerDomain == null ) {
            return null;
        }

        EmployeeManagerDTO.EmployeeManagerDTOBuilder employeeManagerDTO = EmployeeManagerDTO.builder();

        employeeManagerDTO.id( employeeManagerDomain.getId() );
        employeeManagerDTO.name( employeeManagerDomain.getName() );
        employeeManagerDTO.nip( employeeManagerDomain.getNip() );
        employeeManagerDTO.description( employeeManagerDomain.getDescription() );
        employeeManagerDTO.phone( employeeManagerDomain.getPhone() );
        employeeManagerDTO.email( employeeManagerDomain.getEmail() );
        employeeManagerDTO.bankNumber( employeeManagerDomain.getBankNumber() );
        employeeManagerDTO.bankIban( employeeManagerDomain.getBankIban() );
        employeeManagerDTO.address( addressEmployeeDomainListToAddressEmployeeDTOList( employeeManagerDomain.getAddress() ) );

        return employeeManagerDTO.build();
    }

    @Override
    public EmployeeManagerDomain map(EmployeeManagerDTO employeeManagerDTO) {
        if ( employeeManagerDTO == null ) {
            return null;
        }

        EmployeeManagerDomain.EmployeeManagerDomainBuilder employeeManagerDomain = EmployeeManagerDomain.builder();

        employeeManagerDomain.id( employeeManagerDTO.getId() );
        employeeManagerDomain.name( employeeManagerDTO.getName() );
        employeeManagerDomain.nip( employeeManagerDTO.getNip() );
        employeeManagerDomain.description( employeeManagerDTO.getDescription() );
        employeeManagerDomain.phone( employeeManagerDTO.getPhone() );
        employeeManagerDomain.email( employeeManagerDTO.getEmail() );
        employeeManagerDomain.bankNumber( employeeManagerDTO.getBankNumber() );
        employeeManagerDomain.bankIban( employeeManagerDTO.getBankIban() );
        employeeManagerDomain.address( addressEmployeeDTOListToAddressEmployeeDomainList( employeeManagerDTO.getAddress() ) );

        return employeeManagerDomain.build();
    }

    @Override
    public List<EmployeeManagerDTO> mapToDTO(List<EmployeeManagerDomain> employeeManagerDomains) {
        if ( employeeManagerDomains == null ) {
            return null;
        }

        List<EmployeeManagerDTO> list = new ArrayList<EmployeeManagerDTO>( employeeManagerDomains.size() );
        for ( EmployeeManagerDomain employeeManagerDomain : employeeManagerDomains ) {
            list.add( map( employeeManagerDomain ) );
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

        return employeeDTO.build();
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
        addressEmployeeDTO.employee( employeeDomainToEmployeeDTO( addressEmployeeDomain.getEmployee() ) );

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

    protected EmployeeDomain employeeDTOToEmployeeDomain(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        EmployeeDomain.EmployeeDomainBuilder employeeDomain = EmployeeDomain.builder();

        employeeDomain.id( employeeDTO.getId() );
        employeeDomain.name( employeeDTO.getName() );

        return employeeDomain.build();
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
        addressEmployeeDomain.employee( employeeDTOToEmployeeDomain( addressEmployeeDTO.getEmployee() ) );

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
