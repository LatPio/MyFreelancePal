package pl.edu.wszib.MyFreelancePal.service.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProjectDomain {

    private Integer id;
    private String name;

    private List<TaskDomain> tasks;



}
