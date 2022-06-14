package pl.edu.wszib.MyFreelancePal.service.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployerDomain {

    private Integer id;
    private String name;
    private String nip;
    private List<AddressDomain> address;
    private List<ProjectDomain> projects;

}
