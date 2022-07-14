package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class InvoiceServiceEntryDTO {

    private Integer id;
    private String name;
    private List<TaskDTO> tasks;
    private Integer amount;
    private String unit;
    private BigDecimal netPrice;
    private Integer vat;
    private BigDecimal netAmount;
    private BigDecimal vatAmount;
    private BigDecimal preTaxAmount;

}
