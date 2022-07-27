package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import pl.edu.wszib.MyFreelancePal.config.Constants;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployerManagerDTO {

    private Integer id;
    @Length(message = "Name must have at least 2 characters, max length 255 characters.", min = 2, max = 255)
    private String name;
    private String description;
    private String notes;
    @Pattern(regexp = Constants.PHONE_REGEX, message = "Use appropriate form for Phone")
    @Length(message = "Phone must have at least 8 characters, max length 12 characters.", min = 9, max = 18)
    private String phone;
    @Email
    @Pattern(regexp = Constants.EMAIL_REGEX, message = "Use appropriate form for Email")
    @Length(message = "Email must have at least 5 characters, max length 255 characters.", min = 5, max = 255)
    private String email;
    @Pattern(regexp = Constants.NIP_REGEX, message = "Use only numbers and letters")
    @Length(message = "NIP must have at least 8 characters, max length 12 characters.", min = 8, max = 12)
    private String nip;
    private Boolean active;
    private List<AddressEmployerDTO> address;
    private List<ProjectDTO> projects;
}
