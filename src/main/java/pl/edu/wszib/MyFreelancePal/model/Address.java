package pl.edu.wszib.MyFreelancePal.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Address")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String flatNumber;
    private String city;
    private String country;
    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name = "employer_address_map", joinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "employer_id", referencedColumnName = "id"))
    private List<Employer> employer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name = "employee_address_map", joinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"))
    private List<Employee> employee;
}
