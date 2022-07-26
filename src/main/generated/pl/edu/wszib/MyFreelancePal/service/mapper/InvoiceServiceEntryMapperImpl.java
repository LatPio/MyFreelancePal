package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.model.Invoice;
import pl.edu.wszib.MyFreelancePal.model.InvoiceServiceEntry;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceServiceEntryDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-26T12:24:05+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class InvoiceServiceEntryMapperImpl implements InvoiceServiceEntryMapper {

    private final TaskMapper taskMapper = Mappers.getMapper( TaskMapper.class );

    @Override
    public InvoiceServiceEntry map(InvoiceServiceEntryDomain invoiceServiceEntryDomain) {
        if ( invoiceServiceEntryDomain == null ) {
            return null;
        }

        InvoiceServiceEntry.InvoiceServiceEntryBuilder invoiceServiceEntry = InvoiceServiceEntry.builder();

        invoiceServiceEntry.id( invoiceServiceEntryDomain.getId() );
        invoiceServiceEntry.name( invoiceServiceEntryDomain.getName() );
        invoiceServiceEntry.tasks( taskMapper.mapToTasks( invoiceServiceEntryDomain.getTasks() ) );
        invoiceServiceEntry.amount( invoiceServiceEntryDomain.getAmount() );
        invoiceServiceEntry.unit( invoiceServiceEntryDomain.getUnit() );
        invoiceServiceEntry.netPrice( invoiceServiceEntryDomain.getNetPrice() );
        invoiceServiceEntry.vat( invoiceServiceEntryDomain.getVat() );
        invoiceServiceEntry.netAmount( invoiceServiceEntryDomain.getNetAmount() );
        invoiceServiceEntry.vatAmount( invoiceServiceEntryDomain.getVatAmount() );
        invoiceServiceEntry.preTaxAmount( invoiceServiceEntryDomain.getPreTaxAmount() );
        invoiceServiceEntry.idsOfTasks( invoiceServiceEntryDomain.getIdsOfTasks() );
        invoiceServiceEntry.invoice( invoiceDomainToInvoice( invoiceServiceEntryDomain.getInvoice() ) );

        return invoiceServiceEntry.build();
    }

    @Override
    public InvoiceServiceEntryDomain map(InvoiceServiceEntry invoiceServiceEntry) {
        if ( invoiceServiceEntry == null ) {
            return null;
        }

        InvoiceServiceEntryDomain.InvoiceServiceEntryDomainBuilder invoiceServiceEntryDomain = InvoiceServiceEntryDomain.builder();

        invoiceServiceEntryDomain.id( invoiceServiceEntry.getId() );
        invoiceServiceEntryDomain.name( invoiceServiceEntry.getName() );
        invoiceServiceEntryDomain.amount( invoiceServiceEntry.getAmount() );
        invoiceServiceEntryDomain.unit( invoiceServiceEntry.getUnit() );
        invoiceServiceEntryDomain.netPrice( invoiceServiceEntry.getNetPrice() );
        invoiceServiceEntryDomain.vat( invoiceServiceEntry.getVat() );
        invoiceServiceEntryDomain.netAmount( invoiceServiceEntry.getNetAmount() );
        invoiceServiceEntryDomain.vatAmount( invoiceServiceEntry.getVatAmount() );
        invoiceServiceEntryDomain.preTaxAmount( invoiceServiceEntry.getPreTaxAmount() );
        invoiceServiceEntryDomain.invoice( invoiceToInvoiceDomain( invoiceServiceEntry.getInvoice() ) );
        invoiceServiceEntryDomain.tasks( taskMapper.mapToDomain( invoiceServiceEntry.getTasks() ) );
        invoiceServiceEntryDomain.idsOfTasks( invoiceServiceEntry.getIdsOfTasks() );

        return invoiceServiceEntryDomain.build();
    }

    @Override
    public List<InvoiceServiceEntryDomain> mapToDomain(List<InvoiceServiceEntry> invoiceServiceEntries) {
        if ( invoiceServiceEntries == null ) {
            return null;
        }

        List<InvoiceServiceEntryDomain> list = new ArrayList<InvoiceServiceEntryDomain>( invoiceServiceEntries.size() );
        for ( InvoiceServiceEntry invoiceServiceEntry : invoiceServiceEntries ) {
            list.add( map( invoiceServiceEntry ) );
        }

        return list;
    }

    protected Employee employeeDomainToEmployee(EmployeeDomain employeeDomain) {
        if ( employeeDomain == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( employeeDomain.getId() );
        employee.name( employeeDomain.getName() );

        return employee.build();
    }

    protected Address addressEmployeeDomainToAddress(AddressEmployeeDomain addressEmployeeDomain) {
        if ( addressEmployeeDomain == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.id( addressEmployeeDomain.getId() );
        address.name( addressEmployeeDomain.getName() );
        address.street( addressEmployeeDomain.getStreet() );
        address.postalCode( addressEmployeeDomain.getPostalCode() );
        address.buildingNumber( addressEmployeeDomain.getBuildingNumber() );
        address.flatNumber( addressEmployeeDomain.getFlatNumber() );
        address.city( addressEmployeeDomain.getCity() );
        address.country( addressEmployeeDomain.getCountry() );
        address.employee( employeeDomainToEmployee( addressEmployeeDomain.getEmployee() ) );

        return address.build();
    }

    protected List<Address> addressEmployeeDomainListToAddressList(List<AddressEmployeeDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressEmployeeDomain addressEmployeeDomain : list ) {
            list1.add( addressEmployeeDomainToAddress( addressEmployeeDomain ) );
        }

        return list1;
    }

    protected Employee employeeManagerDomainToEmployee(EmployeeManagerDomain employeeManagerDomain) {
        if ( employeeManagerDomain == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.id( employeeManagerDomain.getId() );
        employee.name( employeeManagerDomain.getName() );
        employee.nip( employeeManagerDomain.getNip() );
        employee.description( employeeManagerDomain.getDescription() );
        employee.phone( employeeManagerDomain.getPhone() );
        employee.email( employeeManagerDomain.getEmail() );
        employee.bankNumber( employeeManagerDomain.getBankNumber() );
        employee.bankIban( employeeManagerDomain.getBankIban() );
        employee.address( addressEmployeeDomainListToAddressList( employeeManagerDomain.getAddress() ) );

        return employee.build();
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

        Address.AddressBuilder address = Address.builder();

        address.id( addressEmployerDomain.getId() );
        address.name( addressEmployerDomain.getName() );
        address.street( addressEmployerDomain.getStreet() );
        address.postalCode( addressEmployerDomain.getPostalCode() );
        address.buildingNumber( addressEmployerDomain.getBuildingNumber() );
        address.flatNumber( addressEmployerDomain.getFlatNumber() );
        address.city( addressEmployerDomain.getCity() );
        address.country( addressEmployerDomain.getCountry() );
        address.employer( employerDomainToEmployer( addressEmployerDomain.getEmployer() ) );

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

    protected Project projectDomainToProject(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.id( projectDomain.getId() );
        project.name( projectDomain.getName() );
        project.color( projectDomain.getColor() );
        project.hourPriceDefault( projectDomain.getHourPriceDefault() );

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

    protected Invoice invoiceDomainToInvoice(InvoiceDomain invoiceDomain) {
        if ( invoiceDomain == null ) {
            return null;
        }

        Invoice.InvoiceBuilder invoice = Invoice.builder();

        invoice.id( invoiceDomain.getId() );
        invoice.invoiceCreationDate( invoiceDomain.getInvoiceCreationDate() );
        invoice.secondDate( invoiceDomain.getSecondDate() );
        invoice.employee( employeeManagerDomainToEmployee( invoiceDomain.getEmployee() ) );
        invoice.employer( employerManagerDomainToEmployer( invoiceDomain.getEmployer() ) );
        invoice.employeeAddress( addressEmployeeDomainToAddress( invoiceDomain.getEmployeeAddress() ) );
        invoice.employerAddress( addressEmployerDomainToAddress( invoiceDomain.getEmployerAddress() ) );
        invoice.vat( invoiceDomain.getVat() );
        invoice.amountNet( invoiceDomain.getAmountNet() );
        invoice.amountVat( invoiceDomain.getAmountVat() );
        invoice.amountPreTax( invoiceDomain.getAmountPreTax() );
        invoice.amountInWords( invoiceDomain.getAmountInWords() );
        invoice.payDue( invoiceDomain.getPayDue() );
        invoice.daysToPay( invoiceDomain.getDaysToPay() );

        return invoice.build();
    }

    protected EmployeeDomain employeeToEmployeeDomain(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDomain.EmployeeDomainBuilder employeeDomain = EmployeeDomain.builder();

        employeeDomain.id( employee.getId() );
        employeeDomain.name( employee.getName() );

        return employeeDomain.build();
    }

    protected AddressEmployeeDomain addressToAddressEmployeeDomain(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEmployeeDomain.AddressEmployeeDomainBuilder addressEmployeeDomain = AddressEmployeeDomain.builder();

        addressEmployeeDomain.id( address.getId() );
        addressEmployeeDomain.name( address.getName() );
        addressEmployeeDomain.street( address.getStreet() );
        addressEmployeeDomain.postalCode( address.getPostalCode() );
        addressEmployeeDomain.buildingNumber( address.getBuildingNumber() );
        addressEmployeeDomain.flatNumber( address.getFlatNumber() );
        addressEmployeeDomain.city( address.getCity() );
        addressEmployeeDomain.country( address.getCountry() );
        addressEmployeeDomain.employee( employeeToEmployeeDomain( address.getEmployee() ) );

        return addressEmployeeDomain.build();
    }

    protected List<AddressEmployeeDomain> addressListToAddressEmployeeDomainList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressEmployeeDomain> list1 = new ArrayList<AddressEmployeeDomain>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressEmployeeDomain( address ) );
        }

        return list1;
    }

    protected EmployeeManagerDomain employeeToEmployeeManagerDomain(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeManagerDomain.EmployeeManagerDomainBuilder employeeManagerDomain = EmployeeManagerDomain.builder();

        employeeManagerDomain.id( employee.getId() );
        employeeManagerDomain.name( employee.getName() );
        employeeManagerDomain.nip( employee.getNip() );
        employeeManagerDomain.description( employee.getDescription() );
        employeeManagerDomain.phone( employee.getPhone() );
        employeeManagerDomain.email( employee.getEmail() );
        employeeManagerDomain.bankNumber( employee.getBankNumber() );
        employeeManagerDomain.bankIban( employee.getBankIban() );
        employeeManagerDomain.address( addressListToAddressEmployeeDomainList( employee.getAddress() ) );

        return employeeManagerDomain.build();
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

    protected InvoiceDomain invoiceToInvoiceDomain(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        InvoiceDomain.InvoiceDomainBuilder invoiceDomain = InvoiceDomain.builder();

        invoiceDomain.id( invoice.getId() );
        invoiceDomain.invoiceCreationDate( invoice.getInvoiceCreationDate() );
        invoiceDomain.secondDate( invoice.getSecondDate() );
        invoiceDomain.employee( employeeToEmployeeManagerDomain( invoice.getEmployee() ) );
        invoiceDomain.employer( employerToEmployerManagerDomain( invoice.getEmployer() ) );
        invoiceDomain.employerAddress( addressToAddressEmployerDomain( invoice.getEmployerAddress() ) );
        invoiceDomain.employeeAddress( addressToAddressEmployeeDomain( invoice.getEmployeeAddress() ) );
        invoiceDomain.amountNet( invoice.getAmountNet() );
        invoiceDomain.amountVat( invoice.getAmountVat() );
        invoiceDomain.amountPreTax( invoice.getAmountPreTax() );
        invoiceDomain.amountInWords( invoice.getAmountInWords() );
        invoiceDomain.vat( invoice.getVat() );
        invoiceDomain.payDue( invoice.getPayDue() );
        invoiceDomain.daysToPay( invoice.getDaysToPay() );

        return invoiceDomain.build();
    }
}
