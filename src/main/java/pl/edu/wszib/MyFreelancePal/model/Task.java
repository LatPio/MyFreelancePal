package pl.edu.wszib.MyFreelancePal.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "Task")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
//    @DateTimeFormat(pattern = "HH:mm:ss dd-MM-yyyy")
    private LocalDateTime dateStart;
//    @DateTimeFormat(pattern = "HH:mm:ss dd-MM-yyyy")
    private LocalDateTime dateEnd;
    private Duration time;
    private Boolean invoiceCreated;
    private Instant timeOfInvoiceCreation;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


}
