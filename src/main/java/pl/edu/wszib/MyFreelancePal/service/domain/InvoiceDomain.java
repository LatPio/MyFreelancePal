package pl.edu.wszib.MyFreelancePal.service.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.wszib.MyFreelancePal.model.Employee;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.model.Project;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;
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

    private EmployeeDomain employee;

    private EmployerDomain employer;

    private List<ProjectDomain> projects;

    private Integer priceNet;

    private Integer vat;

    private Date payDue;


}
