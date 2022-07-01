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
    private String description;
    private String notes;
    private String phone;
    private String email;
    private String nip;
    private Boolean active;
    private List<EmployeeDomain> employee;
    private List<AddressEmployerDomain> address;
//    private List<ProjectDomain> projects;

}
