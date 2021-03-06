package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-17T17:03:15+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class InvoiceMapperDTOImpl implements InvoiceMapperDTO {

    @Override
    public InvoiceDTO map(InvoiceDomain invoiceDomain) {
        if ( invoiceDomain == null ) {
            return null;
        }

        InvoiceDTO.InvoiceDTOBuilder invoiceDTO = InvoiceDTO.builder();

        invoiceDTO.id( invoiceDomain.getId() );
        invoiceDTO.invoiceCreationDate( invoiceDomain.getInvoiceCreationDate() );
        invoiceDTO.secondDate( invoiceDomain.getSecondDate() );
        invoiceDTO.invoiceNumber( invoiceDomain.getInvoiceNumber() );
        invoiceDTO.placeOfInvoiceCreation( invoiceDomain.getPlaceOfInvoiceCreation() );
        invoiceDTO.employee( employeeDomainToEmployeeDTO( invoiceDomain.getEmployee() ) );
        invoiceDTO.employer( employerManagerDomainToEmployerManagerDTO( invoiceDomain.getEmployer() ) );
        invoiceDTO.employerAddress( addressEmployerDomainToAddressEmployerDTO( invoiceDomain.getEmployerAddress() ) );
        invoiceDTO.employeeAddress( addressEmployeeDomainToAddressEmployeeDTO( invoiceDomain.getEmployeeAddress() ) );
        invoiceDTO.priceNet( invoiceDomain.getPriceNet() );
        invoiceDTO.priceGross( invoiceDomain.getPriceGross() );
        invoiceDTO.vat( invoiceDomain.getVat() );
        invoiceDTO.payDue( invoiceDomain.getPayDue() );

        return invoiceDTO.build();
    }

    @Override
    public InvoiceDomain map(InvoiceDTO invoiceDTO) {
        if ( invoiceDTO == null ) {
            return null;
        }

        InvoiceDomain.InvoiceDomainBuilder invoiceDomain = InvoiceDomain.builder();

        invoiceDomain.id( invoiceDTO.getId() );
        invoiceDomain.invoiceCreationDate( invoiceDTO.getInvoiceCreationDate() );
        invoiceDomain.secondDate( invoiceDTO.getSecondDate() );
        invoiceDomain.invoiceNumber( invoiceDTO.getInvoiceNumber() );
        invoiceDomain.placeOfInvoiceCreation( invoiceDTO.getPlaceOfInvoiceCreation() );
        invoiceDomain.employee( employeeDTOToEmployeeDomain( invoiceDTO.getEmployee() ) );
        invoiceDomain.employer( employerManagerDTOToEmployerManagerDomain( invoiceDTO.getEmployer() ) );
        invoiceDomain.employerAddress( addressEmployerDTOToAddressEmployerDomain( invoiceDTO.getEmployerAddress() ) );
        invoiceDomain.employeeAddress( addressEmployeeDTOToAddressEmployeeDomain( invoiceDTO.getEmployeeAddress() ) );
        invoiceDomain.priceNet( invoiceDTO.getPriceNet() );
        invoiceDomain.priceGross( invoiceDTO.getPriceGross() );
        invoiceDomain.vat( invoiceDTO.getVat() );
        invoiceDomain.payDue( invoiceDTO.getPayDue() );

        return invoiceDomain.build();
    }

    @Override
    public List<InvoiceDTO> mapToDTO(List<InvoiceDomain> invoiceDomain) {
        if ( invoiceDomain == null ) {
            return null;
        }

        List<InvoiceDTO> list = new ArrayList<InvoiceDTO>( invoiceDomain.size() );
        for ( InvoiceDomain invoiceDomain1 : invoiceDomain ) {
            list.add( map( invoiceDomain1 ) );
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

    protected EmployeeDTO employeeDomainToEmployeeDTO(EmployeeDomain employeeDomain) {
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
        employerManagerDTO.badgeColor( employerManagerDomain.getBadgeColor() );
        employerManagerDTO.nip( employerManagerDomain.getNip() );
        employerManagerDTO.active( employerManagerDomain.getActive() );
        employerManagerDTO.address( addressEmployerDomainListToAddressEmployerDTOList( employerManagerDomain.getAddress() ) );
        employerManagerDTO.projects( projectDomainListToProjectDTOList( employerManagerDomain.getProjects() ) );

        return employerManagerDTO.build();
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

    protected EmployeeDomain employeeDTOToEmployeeDomain(EmployeeDTO employeeDTO) {
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
        employerManagerDomain.badgeColor( employerManagerDTO.getBadgeColor() );
        employerManagerDomain.email( employerManagerDTO.getEmail() );
        employerManagerDomain.nip( employerManagerDTO.getNip() );
        employerManagerDomain.active( employerManagerDTO.getActive() );
        employerManagerDomain.address( addressEmployerDTOListToAddressEmployerDomainList( employerManagerDTO.getAddress() ) );
        employerManagerDomain.projects( projectDTOListToProjectDomainList( employerManagerDTO.getProjects() ) );

        return employerManagerDomain.build();
    }
}
