package pl.edu.wszib.MyFreelancePal.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "InvoiceServiceEntry")
@Entity
public class InvoiceServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "invoiceServiceEntry")
    private List<Task> tasks = new ArrayList<>();
    private Integer amount;
    private String unit;
    private BigDecimal netPrice;
    private Integer vat;
    private BigDecimal netAmount;
    private BigDecimal vatAmount;
    private BigDecimal preTaxAmount;
    private String idsOfTasks;
    @ManyToOne
    @JoinColumn(name = "invoiceId")
    private Invoice invoice;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @PreRemove
    public void nullificationOfTask(){
        tasks.forEach(task -> task.setInvoiceServiceEntry(null));
        tasks.forEach(task -> task.setInvoiceCreated(false));
    }
}
