package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@EqualsAndHashCode
public class InvoiceServiceEntryDTO {

    private Integer id;
    @Length(message = "Name must have at least 2 characters, max length 255 characters.", min = 2, max = 255)
    private String name;
    private Integer amount;
    private String unit;
    private BigDecimal netPrice;
    private Integer vat;
    private BigDecimal netAmount;
    private BigDecimal vatAmount;
    private BigDecimal preTaxAmount;
    private InvoiceDTO invoice;
    private List<TaskDTO> tasks;
    private String idsOfTasks;


}
