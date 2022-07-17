package pl.edu.wszib.MyFreelancePal.service.domain;



import lombok.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@EqualsAndHashCode
public class TaskDomain {

    private Integer id;
    private String name;
    private Long timeOfWorkInMin;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private ProjectDomain projectDomain;
    private Boolean doneTask;
    private Boolean invoiceCreated;
    private BigDecimal hourPrice;

    }