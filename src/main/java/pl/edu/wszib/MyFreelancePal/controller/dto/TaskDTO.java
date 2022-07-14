package pl.edu.wszib.MyFreelancePal.controller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.math.BigDecimal;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateEnd;
    private Boolean invoiceCreated = false;
    private BigDecimal hourPrice;
    private Long timeOfWorkInMin = Long.valueOf(0);;
    private ProjectDTO projectDTO;
    private Boolean doneTask = false;


}
