package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class EmployeeDTO {

    private Integer id;
    private String name;
    private String nip;
    private String bankNumber;
    private String bankIban;
    private List<AddressEmployeeDTO> address;
}
