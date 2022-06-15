package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class ProjectDTO {

    private Integer id;
    private String name;
    private List<TaskDTO> tasks;

}
