package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeDTO {

    private Integer id;
    private String name;

}
