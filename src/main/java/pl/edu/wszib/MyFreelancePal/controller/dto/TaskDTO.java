package pl.edu.wszib.MyFreelancePal.controller.dto;


import lombok.*;


import java.time.Duration;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TaskDTO {

    private Integer id;
    private String name;
    private Duration time;
    private ProjectDTO projectDTO;


}
