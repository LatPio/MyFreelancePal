package pl.edu.wszib.MyFreelancePal.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "Settings")
@Entity
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer vat;
    private BigDecimal defaultHourPrice;
    private String globalCurrency;

}
