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
public class ProjectDomain {

    private Integer id;
    private String name;
    private EmployerDomain employerDomain;
    private String color;
    private BigDecimal hourPriceDefault;


}
