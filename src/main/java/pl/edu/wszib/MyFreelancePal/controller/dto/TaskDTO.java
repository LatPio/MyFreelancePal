package pl.edu.wszib.MyFreelancePal.controller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;

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
//    private Duration time;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateStart;
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateEnd;
    private ProjectDTO projectDTO;


}
