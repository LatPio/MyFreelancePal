package pl.edu.wszib.MyFreelancePal.controller.dto;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProjectManagerDTO {

    private Integer id;
    @Length(message = "Name must have at least 2 characters, max length 255 characters.", min = 2, max = 255)
    private String name;
    private String color;
    private String description;
    private Boolean activeProject;
    @NotNull(message = "Price some price")
    @Positive(message = "Price should be bigger than zero")
    private BigDecimal hourPriceDefault;
    private List<TaskDTO> tasks;
    private EmployerManagerDTO employer;

}
