package pl.edu.wszib.MyFreelancePal.service.domain;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeDomain {

    private Integer id;
    private String name;
    private String nip;
    private String bankNumber;
    private String bankIban;
    private List<AddressEmployeeDomain> address;

}
