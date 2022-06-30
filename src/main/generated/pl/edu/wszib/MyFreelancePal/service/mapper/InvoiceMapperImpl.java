package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.model.Invoice;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-30T22:27:19+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public InvoiceDomain map(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        InvoiceDomain.InvoiceDomainBuilder invoiceDomain = InvoiceDomain.builder();

        invoiceDomain.id( invoice.getId() );
        invoiceDomain.invoiceCreationDate( invoice.getInvoiceCreationDate() );
        invoiceDomain.secondDate( invoice.getSecondDate() );
        invoiceDomain.employee( employeeToEmployeeDomain( invoice.getEmployee() ) );
        invoiceDomain.employer( employerToEmployerDomain( invoice.getEmployer() ) );
        invoiceDomain.projects( projectListToProjectDomainList( invoice.getProjects() ) );
        invoiceDomain.priceNet( invoice.getPriceNet() );
        invoiceDomain.vat( invoice.getVat() );
        invoiceDomain.payDue( invoice.getPayDue() );

        return invoiceDomain.build();
    }

    @Override
    public Invoice map(InvoiceDomain invoiceDomain) {
        if ( invoiceDomain == null ) {
            return null;
        }

        Invoice.InvoiceBuilder invoice = Invoice.builder();

        invoice.id( invoiceDomain.getId() );
        invoice.invoiceCreationDate( invoiceDomain.getInvoiceCreationDate() );
        invoice.secondDate( invoiceDomain.getSecondDate() );
        invoice.employee( employeeDomainToEmployee( invoiceDomain.getEmployee() ) );
        invoice.employer( employerDomainToEmployer( invoiceDomain.getEmployer() ) );
        invoice.projects( projectDomainListToProjectList( invoiceDomain.getProjects() ) );
        invoice.priceNet( invoiceDomain.getPriceNet() );
        invoice.vat( invoiceDomain.getVat() );
        invoice.payDue( invoiceDomain.getPayDue() );

        return invoice.build();
    }

    @Override
    public List<InvoiceDomain> mapToDomain(List<Invoice> invoice) {
        if ( invoice == null ) {
            return null;
        }

        List<InvoiceDomain> list = new ArrayList<InvoiceDomain>( invoice.size() );
        for ( Invoice invoice1 : invoice ) {
            list.add( map( invoice1 ) );
        }

        return list;
    }

    protected EmployeeDomain employeeToEmployeeDomain(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDomain.EmployeeDomainBuilder employeeDomain = EmployeeDomain.builder();

        employeeDomain.id( employee.getId() );
        employeeDomain.name( employee.getName() );
        employeeDomain.nip( employee.getNip() );

        return employeeDomain.build();
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

    protected ProjectDomain projectToProjectDomain(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDomain.ProjectDomainBuilder projectDomain = ProjectDomain.builder();

        projectDomain.id( project.getId() );
        projectDomain.name( project.getName() );

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

    protected Employee employeeDomainToEmployee(EmployeeDomain employeeDomain) {
        if ( employeeDomain == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( employeeDomain.getId() );
        employee.name( employeeDomain.getName() );
        employee.nip( employeeDomain.getNip() );

        return employee.build();
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

    protected Project projectDomainToProject(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.id( projectDomain.getId() );
        project.name( projectDomain.getName() );

        return project.build();
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
}
