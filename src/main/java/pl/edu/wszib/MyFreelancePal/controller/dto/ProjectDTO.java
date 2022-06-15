package pl.edu.wszib.MyFreelancePal.controller.dto;


import lombok.Data;

@Data
public class ProjectDTO {

    private Integer id;
    private String name;

    public ProjectDTO() {
    }

    public ProjectDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
