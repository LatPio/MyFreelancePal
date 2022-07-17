package pl.edu.wszib.MyFreelancePal.service.domain;



import lombok.*;
import pl.edu.wszib.MyFreelancePal.model.InvoiceServiceEntry;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@EqualsAndHashCode
public class TaskInvoiceDomain {

    private Integer id;
    private String name;
    private Long timeOfWorkInMin;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private ProjectDomain projectDomain;
    private Boolean doneTask;
    private Boolean invoiceCreated;
    private BigDecimal hourPrice;
    private Instant timeOfInvoiceCreation;
    private InvoiceServiceEntryDomain invoiceServiceEntry;

    }