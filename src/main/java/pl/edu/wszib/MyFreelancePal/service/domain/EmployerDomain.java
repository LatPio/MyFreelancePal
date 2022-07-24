package pl.edu.wszib.MyFreelancePal.service.domain;

import lombok.*;
import pl.edu.wszib.MyFreelancePal.model.Employee;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployerDomain {

    private Integer id;
    private String name;



}
