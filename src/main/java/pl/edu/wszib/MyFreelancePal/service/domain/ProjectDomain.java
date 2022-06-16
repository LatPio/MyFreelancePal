package pl.edu.wszib.MyFreelancePal.service.domain;


import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProjectDomain {

    private Integer id;
    private String name;
    private EmployerDomain employerDomain;






}
