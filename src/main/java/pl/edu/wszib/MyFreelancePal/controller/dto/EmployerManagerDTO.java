package pl.edu.wszib.MyFreelancePal.controller.dto;


import lombok.*;

import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployerManagerDTO {

    private Integer id;
    private String name;
    private String description;
    private String notes;
    private String phone;
    private String email;
    private String badgeColor;
    private String nip;
    private Boolean active;
//    private List<EmployeeDTO> employee;
    private List<AddressEmployerDTO> address;
    private List<ProjectDTO> projects;
}
