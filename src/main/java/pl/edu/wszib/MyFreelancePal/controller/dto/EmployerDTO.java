package pl.edu.wszib.MyFreelancePal.controller.dto;


import lombok.*;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class EmployerDTO {

    private Integer id;
    private String name;
    private String nip;
    private List<EmployeeDTO> employeeDTO;
//    private List<Address> address;
//    private List<Project> projects;
}
