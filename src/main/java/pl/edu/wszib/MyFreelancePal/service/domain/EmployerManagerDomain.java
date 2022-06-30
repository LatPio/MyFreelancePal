package pl.edu.wszib.MyFreelancePal.service.domain;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployerManagerDomain {

    private Integer id;
    private String name;
    private String nip;
    private List<EmployeeDomain> employeeDomain;
    private List<AddressEmployerDomain> address;
//    private List<ProjectDomain> projects;

}
