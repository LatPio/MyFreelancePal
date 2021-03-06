package pl.edu.wszib.MyFreelancePal.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date invoiceCreationDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date secondDate;
    private String invoiceNumber;
    private String placeOfInvoiceCreation;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InvoiceServiceEntry> invoiceServiceEntries;
    @ManyToOne
    @JoinColumn(name = "EmployeeAddress_id")
    private Address employeeAddress;
    @ManyToOne
    @JoinColumn(name = "EmployerAddress_id")
    private Address employerAddress;
    private BigDecimal priceNet;
    private BigDecimal priceGross;
    private Integer vat;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date payDue;
    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;



}
