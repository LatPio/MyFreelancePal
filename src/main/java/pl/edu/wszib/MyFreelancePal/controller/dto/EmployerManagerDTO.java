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
    private String nip;
    private List<EmployeeDTO> employeeDTO;
    private List<AddressEmployerDTO> address;
//    private List<ProjectDTO> projects;
}
