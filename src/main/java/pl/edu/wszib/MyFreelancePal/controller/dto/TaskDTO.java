package pl.edu.wszib.MyFreelancePal.controller.dto;


import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TaskDTO {

    private Integer id;
    @Length(message = "Name must have at least 2 characters, max length 255 characters.", min = 2, max = 255)
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateEnd;
    private Boolean invoiceCreated = false;
    @NotNull(message = "Price some price")
    @Positive(message = "Price should be bigger than zero")
    private BigDecimal hourPrice;
    private Long timeOfWorkInMin = Long.valueOf(0);;
    private ProjectDTO projectDTO;
    private Boolean doneTask = false;


}
