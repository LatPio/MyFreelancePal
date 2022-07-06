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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateStart;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateEnd;
    private Boolean invoiceCreated = false;
    private Long timeOfWorkInMin = Long.valueOf(0);;
    private ProjectDTO projectDTO;
    private Boolean doneTask = false;


}
