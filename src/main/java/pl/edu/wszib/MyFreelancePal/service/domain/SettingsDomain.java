package pl.edu.wszib.MyFreelancePal.service.domain;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SettingsDomain {

    private  Integer id;
    private  Integer vat;
    private BigDecimal defaultHourPrice;
    private  String globalCurrency;

}
