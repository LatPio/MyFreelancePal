package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.AddressEmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceServiceEntryDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskInvoiceDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerManagerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceServiceEntryDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskInvoiceDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-29T13:06:04+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TaskInvoiceMapperDTOImpl implements TaskInvoiceMapperDTO {

    @Override
    public TaskInvoiceDTO map(TaskInvoiceDomain taskInvoiceDomain) {
        if ( taskInvoiceDomain == null ) {
            return null;
        }

        TaskInvoiceDTO.TaskInvoiceDTOBuilder taskInvoiceDTO = TaskInvoiceDTO.builder();

        taskInvoiceDTO.projectDTO( projectDomainToProjectDTO( taskInvoiceDomain.getProjectDomain() ) );
        taskInvoiceDTO.id( taskInvoiceDomain.getId() );
        taskInvoiceDTO.name( taskInvoiceDomain.getName() );
        taskInvoiceDTO.dateStart( taskInvoiceDomain.getDateStart() );
        taskInvoiceDTO.dateEnd( taskInvoiceDomain.getDateEnd() );
        taskInvoiceDTO.invoiceCreated( taskInvoiceDomain.getInvoiceCreated() );
        taskInvoiceDTO.hourPrice( taskInvoiceDomain.getHourPrice() );
        taskInvoiceDTO.timeOfWorkInMin( taskInvoiceDomain.getTimeOfWorkInMin() );
        taskInvoiceDTO.doneTask( taskInvoiceDomain.getDoneTask() );
        taskInvoiceDTO.timeOfInvoiceCreation( taskInvoiceDomain.getTimeOfInvoiceCreation() );
        taskInvoiceDTO.invoiceServiceEntry( invoiceServiceEntryDomainToInvoiceServiceEntryDTO( taskInvoiceDomain.getInvoiceServiceEntry() ) );

        return taskInvoiceDTO.build();
    }

    @Override
    public TaskInvoiceDomain map(TaskInvoiceDTO taskInvoiceDTO) {
        if ( taskInvoiceDTO == null ) {
            return null;
        }

        TaskInvoiceDomain.TaskInvoiceDomainBuilder taskInvoiceDomain = TaskInvoiceDomain.builder();

        taskInvoiceDomain.projectDomain( projectDTOToProjectDomain( taskInvoiceDTO.getProjectDTO() ) );
        taskInvoiceDomain.id( taskInvoiceDTO.getId() );
        taskInvoiceDomain.name( taskInvoiceDTO.getName() );
        taskInvoiceDomain.timeOfWorkInMin( taskInvoiceDTO.getTimeOfWorkInMin() );
        taskInvoiceDomain.dateStart( taskInvoiceDTO.getDateStart() );
        taskInvoiceDomain.dateEnd( taskInvoiceDTO.getDateEnd() );
        taskInvoiceDomain.doneTask( taskInvoiceDTO.getDoneTask() );
        taskInvoiceDomain.invoiceCreated( taskInvoiceDTO.getInvoiceCreated() );
        taskInvoiceDomain.hourPrice( taskInvoiceDTO.getHourPrice() );
        taskInvoiceDomain.timeOfInvoiceCreation( taskInvoiceDTO.getTimeOfInvoiceCreation() );
        taskInvoiceDomain.invoiceServiceEntry( invoiceServiceEntryDTOToInvoiceServiceEntryDomain( taskInvoiceDTO.getInvoiceServiceEntry() ) );

        return taskInvoiceDomain.build();
    }

    @Override
    public List<TaskInvoiceDTO> mapToDTO(List<TaskInvoiceDomain> taskInvoiceDomains) {
        if ( taskInvoiceDomains == null ) {
            return null;
        }

        List<TaskInvoiceDTO> list = new ArrayList<TaskInvoiceDTO>( taskInvoiceDomains.size() );
        for ( TaskInvoiceDomain taskInvoiceDomain : taskInvoiceDomains ) {
            list.add( map( taskInvoiceDomain ) );
        }

        return list;
    }

    @Override
    public List<TaskInvoiceDomain> mapToDomain(List<TaskInvoiceDTO> taskInvoiceDTOS) {
        if ( taskInvoiceDTOS == null ) {
            return null;
        }

        List<TaskInvoiceDomain> list = new ArrayList<TaskInvoiceDomain>( taskInvoiceDTOS.size() );
        for ( TaskInvoiceDTO taskInvoiceDTO : taskInvoiceDTOS ) {
            list.add( map( taskInvoiceDTO ) );
        }

        return list;
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

    protected EmployeeManagerDTO employeeManagerDomainToEmployeeManagerDTO(EmployeeManagerDomain employeeManagerDomain) {
        if ( employeeManagerDomain == null ) {
            return null;
        }

        EmployeeManagerDTO.EmployeeManagerDTOBuilder employeeManagerDTO = EmployeeManagerDTO.builder();

        employeeManagerDTO.id( employeeManagerDomain.getId() );
        employeeManagerDTO.name( employeeManagerDomain.getName() );
        employeeManagerDTO.nip( employeeManagerDomain.getNip() );
        employeeManagerDTO.vat( employeeManagerDomain.getVat() );
        employeeManagerDTO.currency( employeeManagerDomain.getCurrency() );
        employeeManagerDTO.description( employeeManagerDomain.getDescription() );
        employeeManagerDTO.phone( employeeManagerDomain.getPhone() );
        employeeManagerDTO.email( employeeManagerDomain.getEmail() );
        employeeManagerDTO.bankNumber( employeeManagerDomain.getBankNumber() );
        employeeManagerDTO.bankIban( employeeManagerDomain.getBankIban() );
        employeeManagerDTO.address( addressEmployeeDomainListToAddressEmployeeDTOList( employeeManagerDomain.getAddress() ) );

        return employeeManagerDTO.build();
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
        employerManagerDTO.setProjects( projectDomainListToProjectDTOList( employerManagerDomain.getProjects() ) );

        return employerManagerDTO;
    }

    protected InvoiceDTO invoiceDomainToInvoiceDTO(InvoiceDomain invoiceDomain) {
        if ( invoiceDomain == null ) {
            return null;
        }

        InvoiceDTO.InvoiceDTOBuilder invoiceDTO = InvoiceDTO.builder();

        invoiceDTO.id( invoiceDomain.getId() );
        invoiceDTO.invoiceCreationDate( invoiceDomain.getInvoiceCreationDate() );
        invoiceDTO.secondDate( invoiceDomain.getSecondDate() );
        invoiceDTO.employee( employeeManagerDomainToEmployeeManagerDTO( invoiceDomain.getEmployee() ) );
        invoiceDTO.employer( employerManagerDomainToEmployerManagerDTO( invoiceDomain.getEmployer() ) );
        invoiceDTO.employerAddress( addressEmployerDomainToAddressEmployerDTO( invoiceDomain.getEmployerAddress() ) );
        invoiceDTO.employeeAddress( addressEmployeeDomainToAddressEmployeeDTO( invoiceDomain.getEmployeeAddress() ) );
        invoiceDTO.amountNet( invoiceDomain.getAmountNet() );
        invoiceDTO.amountVat( invoiceDomain.getAmountVat() );
        invoiceDTO.amountPreTax( invoiceDomain.getAmountPreTax() );
        invoiceDTO.amountInWords( invoiceDomain.getAmountInWords() );
        invoiceDTO.vat( invoiceDomain.getVat() );
        invoiceDTO.payDue( invoiceDomain.getPayDue() );
        invoiceDTO.daysToPay( invoiceDomain.getDaysToPay() );

        return invoiceDTO.build();
    }

    protected TaskDTO taskDomainToTaskDTO(TaskDomain taskDomain) {
        if ( taskDomain == null ) {
            return null;
        }

        TaskDTO.TaskDTOBuilder taskDTO = TaskDTO.builder();

        taskDTO.id( taskDomain.getId() );
        taskDTO.name( taskDomain.getName() );
        taskDTO.dateStart( taskDomain.getDateStart() );
        taskDTO.dateEnd( taskDomain.getDateEnd() );
        taskDTO.invoiceCreated( taskDomain.getInvoiceCreated() );
        taskDTO.hourPrice( taskDomain.getHourPrice() );
        taskDTO.timeOfWorkInMin( taskDomain.getTimeOfWorkInMin() );
        taskDTO.doneTask( taskDomain.getDoneTask() );

        return taskDTO.build();
    }

    protected List<TaskDTO> taskDomainListToTaskDTOList(List<TaskDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskDTO> list1 = new ArrayList<TaskDTO>( list.size() );
        for ( TaskDomain taskDomain : list ) {
            list1.add( taskDomainToTaskDTO( taskDomain ) );
        }

        return list1;
    }

    protected InvoiceServiceEntryDTO invoiceServiceEntryDomainToInvoiceServiceEntryDTO(InvoiceServiceEntryDomain invoiceServiceEntryDomain) {
        if ( invoiceServiceEntryDomain == null ) {
            return null;
        }

        InvoiceServiceEntryDTO.InvoiceServiceEntryDTOBuilder invoiceServiceEntryDTO = InvoiceServiceEntryDTO.builder();

        invoiceServiceEntryDTO.id( invoiceServiceEntryDomain.getId() );
        invoiceServiceEntryDTO.name( invoiceServiceEntryDomain.getName() );
        invoiceServiceEntryDTO.amount( invoiceServiceEntryDomain.getAmount() );
        invoiceServiceEntryDTO.unit( invoiceServiceEntryDomain.getUnit() );
        invoiceServiceEntryDTO.netPrice( invoiceServiceEntryDomain.getNetPrice() );
        invoiceServiceEntryDTO.vat( invoiceServiceEntryDomain.getVat() );
        invoiceServiceEntryDTO.netAmount( invoiceServiceEntryDomain.getNetAmount() );
        invoiceServiceEntryDTO.vatAmount( invoiceServiceEntryDomain.getVatAmount() );
        invoiceServiceEntryDTO.preTaxAmount( invoiceServiceEntryDomain.getPreTaxAmount() );
        invoiceServiceEntryDTO.invoice( invoiceDomainToInvoiceDTO( invoiceServiceEntryDomain.getInvoice() ) );
        invoiceServiceEntryDTO.tasks( taskDomainListToTaskDTOList( invoiceServiceEntryDomain.getTasks() ) );
        invoiceServiceEntryDTO.idsOfTasks( invoiceServiceEntryDomain.getIdsOfTasks() );

        return invoiceServiceEntryDTO.build();
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

    protected EmployeeManagerDomain employeeManagerDTOToEmployeeManagerDomain(EmployeeManagerDTO employeeManagerDTO) {
        if ( employeeManagerDTO == null ) {
            return null;
        }

        EmployeeManagerDomain.EmployeeManagerDomainBuilder employeeManagerDomain = EmployeeManagerDomain.builder();

        employeeManagerDomain.id( employeeManagerDTO.getId() );
        employeeManagerDomain.name( employeeManagerDTO.getName() );
        employeeManagerDomain.nip( employeeManagerDTO.getNip() );
        employeeManagerDomain.vat( employeeManagerDTO.getVat() );
        employeeManagerDomain.currency( employeeManagerDTO.getCurrency() );
        employeeManagerDomain.description( employeeManagerDTO.getDescription() );
        employeeManagerDomain.phone( employeeManagerDTO.getPhone() );
        employeeManagerDomain.email( employeeManagerDTO.getEmail() );
        employeeManagerDomain.bankNumber( employeeManagerDTO.getBankNumber() );
        employeeManagerDomain.bankIban( employeeManagerDTO.getBankIban() );
        employeeManagerDomain.address( addressEmployeeDTOListToAddressEmployeeDomainList( employeeManagerDTO.getAddress() ) );

        return employeeManagerDomain.build();
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

    protected InvoiceDomain invoiceDTOToInvoiceDomain(InvoiceDTO invoiceDTO) {
        if ( invoiceDTO == null ) {
            return null;
        }

        InvoiceDomain.InvoiceDomainBuilder invoiceDomain = InvoiceDomain.builder();

        invoiceDomain.id( invoiceDTO.getId() );
        invoiceDomain.invoiceCreationDate( invoiceDTO.getInvoiceCreationDate() );
        invoiceDomain.secondDate( invoiceDTO.getSecondDate() );
        invoiceDomain.employee( employeeManagerDTOToEmployeeManagerDomain( invoiceDTO.getEmployee() ) );
        invoiceDomain.employer( employerManagerDTOToEmployerManagerDomain( invoiceDTO.getEmployer() ) );
        invoiceDomain.employerAddress( addressEmployerDTOToAddressEmployerDomain( invoiceDTO.getEmployerAddress() ) );
        invoiceDomain.employeeAddress( addressEmployeeDTOToAddressEmployeeDomain( invoiceDTO.getEmployeeAddress() ) );
        invoiceDomain.amountNet( invoiceDTO.getAmountNet() );
        invoiceDomain.amountVat( invoiceDTO.getAmountVat() );
        invoiceDomain.amountPreTax( invoiceDTO.getAmountPreTax() );
        invoiceDomain.amountInWords( invoiceDTO.getAmountInWords() );
        invoiceDomain.vat( invoiceDTO.getVat() );
        invoiceDomain.payDue( invoiceDTO.getPayDue() );
        invoiceDomain.daysToPay( invoiceDTO.getDaysToPay() );

        return invoiceDomain.build();
    }

    protected TaskDomain taskDTOToTaskDomain(TaskDTO taskDTO) {
        if ( taskDTO == null ) {
            return null;
        }

        TaskDomain.TaskDomainBuilder taskDomain = TaskDomain.builder();

        taskDomain.id( taskDTO.getId() );
        taskDomain.name( taskDTO.getName() );
        taskDomain.timeOfWorkInMin( taskDTO.getTimeOfWorkInMin() );
        taskDomain.dateStart( taskDTO.getDateStart() );
        taskDomain.dateEnd( taskDTO.getDateEnd() );
        taskDomain.doneTask( taskDTO.getDoneTask() );
        taskDomain.invoiceCreated( taskDTO.getInvoiceCreated() );
        taskDomain.hourPrice( taskDTO.getHourPrice() );

        return taskDomain.build();
    }

    protected List<TaskDomain> taskDTOListToTaskDomainList(List<TaskDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskDomain> list1 = new ArrayList<TaskDomain>( list.size() );
        for ( TaskDTO taskDTO : list ) {
            list1.add( taskDTOToTaskDomain( taskDTO ) );
        }

        return list1;
    }

    protected InvoiceServiceEntryDomain invoiceServiceEntryDTOToInvoiceServiceEntryDomain(InvoiceServiceEntryDTO invoiceServiceEntryDTO) {
        if ( invoiceServiceEntryDTO == null ) {
            return null;
        }

        InvoiceServiceEntryDomain.InvoiceServiceEntryDomainBuilder invoiceServiceEntryDomain = InvoiceServiceEntryDomain.builder();

        invoiceServiceEntryDomain.id( invoiceServiceEntryDTO.getId() );
        invoiceServiceEntryDomain.name( invoiceServiceEntryDTO.getName() );
        invoiceServiceEntryDomain.amount( invoiceServiceEntryDTO.getAmount() );
        invoiceServiceEntryDomain.unit( invoiceServiceEntryDTO.getUnit() );
        invoiceServiceEntryDomain.netPrice( invoiceServiceEntryDTO.getNetPrice() );
        invoiceServiceEntryDomain.vat( invoiceServiceEntryDTO.getVat() );
        invoiceServiceEntryDomain.netAmount( invoiceServiceEntryDTO.getNetAmount() );
        invoiceServiceEntryDomain.vatAmount( invoiceServiceEntryDTO.getVatAmount() );
        invoiceServiceEntryDomain.preTaxAmount( invoiceServiceEntryDTO.getPreTaxAmount() );
        invoiceServiceEntryDomain.invoice( invoiceDTOToInvoiceDomain( invoiceServiceEntryDTO.getInvoice() ) );
        invoiceServiceEntryDomain.tasks( taskDTOListToTaskDomainList( invoiceServiceEntryDTO.getTasks() ) );
        invoiceServiceEntryDomain.idsOfTasks( invoiceServiceEntryDTO.getIdsOfTasks() );

        return invoiceServiceEntryDomain.build();
    }
}
