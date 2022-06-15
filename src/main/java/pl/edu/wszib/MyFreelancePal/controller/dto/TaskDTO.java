package pl.edu.wszib.MyFreelancePal.controller.dto;



import lombok.Getter;
import lombok.Setter;

import java.time.Duration;


@Setter
@Getter
public class TaskDTO {

    private Integer id;
    private String name;
    private Duration time;




}
