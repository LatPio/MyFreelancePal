package pl.edu.wszib.MyFreelancePal.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Table()
@Entity(name = "Employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "NIP", nullable = false)
    private String nip;

    private String phone;
    @Email
    private String email;


    @ManyToMany(mappedBy = "employer", fetch = FetchType.LAZY)
    private List<Address> address;

    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Project> projects;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employer_employee_map",
               joinColumns = @JoinColumn(name = "employer_id",
                                        referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "employee_id",
                                        referencedColumnName = "id"))
    private List<Employee> employee;

    @OneToOne(mappedBy = "employer")
    private Invoice invoice;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}
