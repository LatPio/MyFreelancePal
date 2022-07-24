package pl.edu.wszib.MyFreelancePal.controller.dto;


import lombok.*;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Project;

import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployerDTO {

    private Integer id;
    private String name;


}
