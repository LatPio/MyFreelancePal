package pl.edu.wszib.MyFreelancePal.service.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDomain {

    private Integer id;
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String flatNumber;
    private String city;
    private String country;


}
