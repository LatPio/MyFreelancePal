package pl.edu.wszib.MyFreelancePal.controller.dto;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SettingsDTO{
    private  Integer id;
    private  Integer vat;
    private BigDecimal defaultHourPrice;
    private  String globalCurrency;
}
