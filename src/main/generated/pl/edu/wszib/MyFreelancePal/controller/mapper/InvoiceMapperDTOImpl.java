package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-01T17:02:37+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
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
        invoiceDTO.employee( employeeDomainToEmployeeDTO( invoiceDomain.getEmployee() ) );
        invoiceDTO.employer( employerDomainToEmployerDTO( invoiceDomain.getEmployer() ) );
        invoiceDTO.projects( projectDomainListToProjectDTOList( invoiceDomain.getProjects() ) );
        invoiceDTO.priceNet( invoiceDomain.getPriceNet() );
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
        invoiceDomain.employee( employeeDTOToEmployeeDomain( invoiceDTO.getEmployee() ) );
        invoiceDomain.employer( employerDTOToEmployerDomain( invoiceDTO.getEmployer() ) );
        invoiceDomain.projects( projectDTOListToProjectDomainList( invoiceDTO.getProjects() ) );
        invoiceDomain.priceNet( invoiceDTO.getPriceNet() );
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

    protected EmployerDTO employerDomainToEmployerDTO(EmployerDomain employerDomain) {
        if ( employerDomain == null ) {
            return null;
        }

        EmployerDTO.EmployerDTOBuilder employerDTO = EmployerDTO.builder();

        employerDTO.id( employerDomain.getId() );
        employerDTO.name( employerDomain.getName() );
        employerDTO.nip( employerDomain.getNip() );
        employerDTO.address( addressEmployerDomainListToAddressEmployerDTOList( employerDomain.getAddress() ) );

        return employerDTO.build();
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

    protected EmployerDomain employerDTOToEmployerDomain(EmployerDTO employerDTO) {
        if ( employerDTO == null ) {
            return null;
        }

        EmployerDomain.EmployerDomainBuilder employerDomain = EmployerDomain.builder();

        employerDomain.id( employerDTO.getId() );
        employerDomain.name( employerDTO.getName() );
        employerDomain.nip( employerDTO.getNip() );
        employerDomain.address( addressEmployerDTOListToAddressEmployerDomainList( employerDTO.getAddress() ) );

        return employerDomain.build();
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
}
