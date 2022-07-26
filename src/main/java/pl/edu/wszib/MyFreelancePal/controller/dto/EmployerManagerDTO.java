package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployerManagerDTO {

    private Integer id;
    @NotBlank(message = "Name must be filed")
    private String name;
    private String description;
    private String notes;
    private String phone;
    private String email;
    private String nip;
    private Boolean active;
    private List<AddressEmployerDTO> address;
    private List<ProjectDTO> projects;
}
