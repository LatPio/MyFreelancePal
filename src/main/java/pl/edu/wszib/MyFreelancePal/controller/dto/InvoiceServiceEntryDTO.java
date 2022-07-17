package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;

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
