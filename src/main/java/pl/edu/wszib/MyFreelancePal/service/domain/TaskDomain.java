package pl.edu.wszib.MyFreelancePal.service.domain;



import lombok.Data;

import java.time.Duration;

@Data
public class TaskDomain {

    private Integer id;
    private String name;
    private Duration time;
    private ProjectDomain projectDomain;

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

    public ProjectDomain getProjectDomain() {
        return projectDomain;
    }

    public void setProjectDomain(ProjectDomain projectDomain) {
        this.projectDomain = projectDomain;
    }
}
