package pl.edu.wszib.MyFreelancePal.model;


import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@EqualsAndHashCode
@Table(name = "Task")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private Long timeOfWorkInMin;
    private Boolean invoiceCreated;
    private Instant timeOfInvoiceCreation;
    @ColumnDefault(value = "false")
    private Boolean doneTask;
    private BigDecimal hourPrice;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    @JoinColumn(name = "invoiceServiceEntryId")
    private InvoiceServiceEntry invoiceServiceEntry;


}
