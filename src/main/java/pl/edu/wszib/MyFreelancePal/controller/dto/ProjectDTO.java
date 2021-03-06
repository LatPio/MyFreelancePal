package pl.edu.wszib.MyFreelancePal.controller.dto;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProjectDTO {

    private Integer id;
    private String name;
    private EmployerDTO employerDTO;

}
