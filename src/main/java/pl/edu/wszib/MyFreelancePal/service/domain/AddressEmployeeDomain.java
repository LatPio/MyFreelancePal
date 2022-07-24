package pl.edu.wszib.MyFreelancePal.service.domain;


import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AddressEmployeeDomain {

    private Integer id;
    private String name;
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String flatNumber;
    private String city;
    private String country;
    private EmployeeDomain employee;



}
