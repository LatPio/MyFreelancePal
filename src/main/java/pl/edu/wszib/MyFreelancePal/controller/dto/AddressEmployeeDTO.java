package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class AddressEmployeeDTO {

    private Integer id;
    private String name;
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String flatNumber;
    private String city;
    private String country;
//    private EmployeeDTO employee;


}
