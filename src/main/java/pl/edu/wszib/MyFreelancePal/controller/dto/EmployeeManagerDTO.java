package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import pl.edu.wszib.MyFreelancePal.config.Constants;

import javax.validation.constraints.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class EmployeeManagerDTO {

    private Integer id;
    @Length(message = "Name must have at least 2 characters, max length 255 characters.", min = 2, max = 255)
    private String name;
    @Pattern(regexp = Constants.NIP_REGEX, message = "Use only numbers and letters")
    @Length(message = "NIP must have at least 8 characters, max length 12 characters.", min = 8, max = 12)
    private String nip;
    @PositiveOrZero(message = "VAT should be a positive number")
    @NotNull(message = "VAT must have at least 1 characters, max length 2 characters.")
    private Integer vat;
    @Length(message = "Use 3 letters abbreviation of currency.", min = 3, max = 3)
    private String currency;
    private String description;
    @Pattern(regexp = Constants.PHONE_REGEX, message = "Use appropriate form for Phone")
    @Length(message = "Phone must have at least 8 characters, max length 12 characters.", min = 9, max = 18)
    private String phone;
    @Email
    @Pattern(regexp = Constants.EMAIL_REGEX, message = "Use appropriate form for Email")
    @Length(message = "Email must have at least 5 characters, max length 255 characters.", min = 5, max = 255)
    private String email;
    @Pattern(regexp = "[A-Z\\d]+", message = "You should use only numbers and letters")
    @Length(message = "Bank Number must have at least 16 characters, max length 34 characters.", min = 16, max = 34)
    private String bankNumber;
    @Pattern(regexp = "[A-Z\\d]+", message = "You should use only numbers and letters")
    @Length(message = "Iban must have at least 16 characters, max length 34 characters.", min = 16, max = 34)
    private String bankIban;
    private List<AddressEmployeeDTO> address;
}
