package pl.edu.wszib.MyFreelancePal.service.domain;

import lombok.*;

import javax.persistence.Column;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeManagerDomain {

    private Integer id;
    private String name;
    private String nip;
    private Integer vat;
    private String currency;
    private String description;
    private String phone;
    private String email;
    private String bankNumber;
    private String bankIban;
    private List<AddressEmployeeDomain> address;

}
