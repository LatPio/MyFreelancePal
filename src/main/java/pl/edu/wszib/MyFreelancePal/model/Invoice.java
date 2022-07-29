package pl.edu.wszib.MyFreelancePal.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.wszib.MyFreelancePal.util.IdGeneratorForInvoice;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "Invoice")
@Entity
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")
    @GenericGenerator(
        name = "invoice_seq",
        strategy = "pl.edu.wszib.MyFreelancePal.util.IdGeneratorForInvoice",
        parameters = {@org.hibernate.annotations.Parameter(name = IdGeneratorForInvoice.INCREMENT_PARAM, value = "50")}
    )
    @Column(name = "ID", nullable = false)
    private String id;
    @Column(name = "InvoiceCreationDate")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date invoiceCreationDate;
    @Column(name = "InvoiceDateOfWorkCompletion")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date secondDate;
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
    @Column(name = "VAT")
    private Integer vat;
    @Column(name = "AmountNet")
    private BigDecimal amountNet;
    @Column(name = "AmountVAT")
    private BigDecimal amountVat;
    @Column(name = "AmountPreTax")
    private BigDecimal amountPreTax;
    @Column(name = "AmountInWords")
    private String amountInWords;
    @Column(name = "PayDueDate")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date payDue;
    @Column(name = "DaysToPay")
    private Integer daysToPay;
    @CreationTimestamp
    @Column(name = "CreatindDate", updatable = false)
    private Instant createdAt;
    @Column(name = "UpdateDate")
    @UpdateTimestamp
    private Instant updatedAt;



}
