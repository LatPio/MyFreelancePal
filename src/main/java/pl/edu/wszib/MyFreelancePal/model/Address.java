package pl.edu.wszib.MyFreelancePal.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Address")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String street;
    private String postalCode;
    private String buldingNumber;
    private String flatNumber;
    private String city;
    private String country;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name = "employer_address_map", joinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "employer_id", referencedColumnName = "id"))
    private List<Employer> employer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name = "employe_address_map", joinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employe_id", referencedColumnName = "id"))
    private List<Employe> employe;
}
