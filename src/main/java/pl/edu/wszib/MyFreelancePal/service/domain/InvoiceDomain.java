package pl.edu.wszib.MyFreelancePal.service.domain;

import lombok.*;
import pl.edu.wszib.MyFreelancePal.model.InvoiceServiceEntry;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class InvoiceDomain {


    private Integer id;
    private Date invoiceCreationDate;
    private Date secondDate;
    private String invoiceNumber;
    private String placeOfInvoiceCreation;
    private EmployeeDomain employee;
    private EmployerManagerDomain employer;
    private AddressEmployerDomain employerAddress;
    private AddressEmployeeDomain employeeAddress;
//    private List<InvoiceServiceEntryDomain> invoiceServiceEntries;
    private BigDecimal priceNet;
    private BigDecimal priceGross;
    private Integer vat;
    private Date payDue;


}
