package pl.edu.wszib.MyFreelancePal.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "Address")
@Entity
public class Address {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Street", nullable = false)
    private String street;
    @Column(name = "PostalCode", nullable = false)
    private String postalCode;
    @Column(name = "BuildingNumber", nullable = false)
    private String buildingNumber;
    @Column(name = "FlatNumber")
    private String flatNumber;
    @Column(name = "City", nullable = false)
    private String city;
    @Column(name = "Country", nullable = false)
    private String country;
    @CreationTimestamp
    @Column(name = "CreatindDate", updatable = false)
    private Instant createdAt;
    @Column(name = "UpdateDate")
    @UpdateTimestamp
    private Instant updatedAt;

    @OneToMany(mappedBy = "employerAddress")
    private List<Invoice> invoiceAddressEmployer;
    @OneToMany(mappedBy = "employeeAddress")
    private List<Invoice> invoiceAddressEmployee;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
