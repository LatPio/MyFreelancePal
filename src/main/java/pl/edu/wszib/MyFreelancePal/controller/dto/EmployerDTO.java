package pl.edu.wszib.MyFreelancePal.controller.dto;


import lombok.Getter;
import lombok.Setter;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Project;

import java.util.List;

@Getter
@Setter
public class EmployerDTO {

    private Integer id;
    private String name;
    private String nip;
    private List<Address> address;
    private List<Project> projects;
}
