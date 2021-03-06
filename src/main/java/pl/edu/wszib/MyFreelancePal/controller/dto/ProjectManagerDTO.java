package pl.edu.wszib.MyFreelancePal.controller.dto;


import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@EqualsAndHashCode
public class ProjectManagerDTO {

    private Integer id;
    private String name;
    private String color;
    private String description;
    private Boolean activeProject;
    private BigDecimal hourPriceDefault;
    private List<TaskDTO> tasks;
    private EmployerManagerDTO employer;

}
