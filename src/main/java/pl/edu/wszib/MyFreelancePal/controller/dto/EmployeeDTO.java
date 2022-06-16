package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class EmployeeDTO {

    private Integer id;
    private String name;
    private String nip;
}
