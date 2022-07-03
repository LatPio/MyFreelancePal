package pl.edu.wszib.MyFreelancePal.service.domain;


import lombok.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;

import java.math.BigDecimal;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProjectManagerDomain {

    private Integer id;
    private String name;
    private String color;
    private String description;
    private Boolean activeProject;
    private BigDecimal hourPrice;
    private List<TaskDomain> tasks;
    private EmployerManagerDomain employer;






}
