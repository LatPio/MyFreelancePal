package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;

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
    private EmployeeDTO employee;
    private EmployerDTO employer;
    private List<ProjectDTO> projects;
    private Integer priceNet;
    private Integer vat;
    private Date payDue;


}
