package pl.edu.wszib.MyFreelancePal.service.domain;

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
public class InvoiceServiceEntryDomain {


    private Integer id;
    private String name;
    private Integer amount;
    private String unit;
    private BigDecimal netPrice;
    private Integer vat;
    private BigDecimal netAmount;
    private BigDecimal vatAmount;
    private BigDecimal preTaxAmount;
    private InvoiceDomain invoice;
    private List<TaskDomain> tasks;
}
