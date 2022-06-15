package pl.edu.wszib.MyFreelancePal.controller.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
@Data
public class TaskDTO {

    private Integer id;
    private String name;
    private Duration time;
    private ProjectDTO projectDTO;

    public TaskDTO() {
    }

    public TaskDTO(Integer id, String name, Duration time, ProjectDTO projectDTO) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.projectDTO = projectDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }
}
