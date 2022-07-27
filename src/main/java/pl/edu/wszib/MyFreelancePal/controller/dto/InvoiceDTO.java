package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Choose One of your Profile. If field is empty add Profile")
    private EmployeeManagerDTO employee;
    @NotNull(message = "Choose Employer to Issue a Invoice. If field is empty add Employer")
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
