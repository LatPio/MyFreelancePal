package pl.edu.wszib.MyFreelancePal.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
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
public class InvoiceServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "invoiceServiceEntry")
    private List<Task> tasks;
    private Integer amount;
    private String unit;
    private BigDecimal netPrice;
    private Integer vat;
    private BigDecimal netAmount;
    private BigDecimal vatAmount;
    private BigDecimal preTaxAmount;
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}
