package pl.edu.wszib.MyFreelancePal.service.domain;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class InvoiceDomain {


    private String id;
    private Date invoiceCreationDate;
    private Date secondDate;
    private String invoiceNumber;
    private String placeOfInvoiceCreation;
    private EmployeeManagerDomain employee;
    private EmployerManagerDomain employer;
    private AddressEmployerDomain employerAddress;
    private AddressEmployeeDomain employeeAddress;
    private BigDecimal amountNet;
    private BigDecimal amountVat;
    private BigDecimal amountPreTax;
    private String amountInWords;
    private Integer vat;
    private Date payDue;
    private Integer daysToPay;


}
