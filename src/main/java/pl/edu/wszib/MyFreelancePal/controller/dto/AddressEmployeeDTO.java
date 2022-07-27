package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class AddressEmployeeDTO {

    private Integer id;
    @Length(message = "Name must have at least 2 characters, max length 255 characters.", min = 2, max = 255)
    private String name;
    @Length(message = "Street must have at least 2 characters, max length 255 characters.", min = 2, max = 255)
    private String street;
    @Length(message = "Postal Code must have at least 2 characters, max length 10 characters.", min = 2, max = 10)
    private String postalCode;
    @Length(message = "Building number must have at least 1 characters, max length 10 characters.", min = 1, max = 10)
    private String buildingNumber;
    private String flatNumber;
    @Length(message = "City must have at least 3 characters, max length 255 characters.", min = 3, max = 255)
    private String city;
    @Length(message = "Country must have at least 3 characters, max length 255 characters.", min = 3, max = 255)
    private String country;
    private EmployeeDTO employee;


}
