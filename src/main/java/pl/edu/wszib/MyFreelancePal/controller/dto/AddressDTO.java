package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private Integer id;
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String flatNumber;
    private String city;
    private String country;


}
