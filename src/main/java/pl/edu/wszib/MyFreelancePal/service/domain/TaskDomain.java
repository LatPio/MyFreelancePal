package pl.edu.wszib.MyFreelancePal.service.domain;



import lombok.*;

import java.time.Duration;

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
    private Duration time;
    private ProjectDomain projectDomain;

    }