package pl.edu.wszib.MyFreelancePal.controller.dto;

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
public class InvoiceDTO {


    private String id;
    private Date invoiceCreationDate;
    private Date secondDate;
    private String invoiceNumber;
    private String placeOfInvoiceCreation;
    private EmployeeManagerDTO employee;
    private EmployerManagerDTO employer;
    private AddressEmployerDTO employerAddress;
    private AddressEmployeeDTO employeeAddress;
    private BigDecimal amountNet;
    private BigDecimal amountVat;
    private BigDecimal amountPreTax;
    private String amountInWords;
    private Integer vat;
    private Date payDue;
    private Integer daysToPay;


}
