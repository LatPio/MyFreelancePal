package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceServiceEntryDomain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class InvoiceDTO {


    private Integer id;
    private Date invoiceCreationDate;
    private Date secondDate;
    private String invoiceNumber;
    private String placeOfInvoiceCreation;
    private EmployeeDTO employee;
    private EmployerManagerDTO employer;
    private AddressEmployerDTO employerAddress;
    private AddressEmployeeDTO employeeAddress;
//    private List<InvoiceServiceEntryDTO> invoiceServiceEntries;
    private BigDecimal amountNet;
    private BigDecimal amountVat;
    private BigDecimal amountPreTax;
    private Integer vat;
    private Date payDue;
    private Integer daysToPay;


}
