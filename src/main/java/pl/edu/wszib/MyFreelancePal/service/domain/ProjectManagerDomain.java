package pl.edu.wszib.MyFreelancePal.service.domain;


import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@EqualsAndHashCode
public class ProjectManagerDomain {

    private Integer id;
    private String name;
    private String color;
    private String description;
    private Boolean activeProject;
    private BigDecimal hourPriceDefault;
    private List<TaskDomain> tasks;
    private EmployerManagerDomain employer;






}
