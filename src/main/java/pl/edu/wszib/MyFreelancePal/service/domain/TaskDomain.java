package pl.edu.wszib.MyFreelancePal.service.domain;



import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TaskDomain {

    private Integer id;
    private String name;
    private Long timeOfWorkInMin;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private ProjectDomain projectDomain;

    }