package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class EmployeeManagerDTO {

    private Integer id;
    private String name;
    private String nip;
    private String description;
    private String phone;
    private String email;
    private String bankNumber;
    private String bankIban;
    private List<AddressEmployeeDTO> address;
}
