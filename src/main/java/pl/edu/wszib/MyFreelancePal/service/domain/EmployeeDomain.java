package pl.edu.wszib.MyFreelancePal.service.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeDomain {
    private Integer id;
    private String name;
}
