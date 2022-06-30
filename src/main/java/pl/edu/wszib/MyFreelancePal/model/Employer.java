package pl.edu.wszib.MyFreelancePal.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.awt.*;
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
    private String description;
    private String notes;
    @Column(name = "NIP", nullable = false)
    private String nip;
    private String phone;
    @Email
    private String email;
    private Color badgeColor;
    @Column(nullable = true)
    private Boolean active;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
    private List<Address> address;

    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Project> projects;

    @ManyToMany
    @JoinTable(name = "employer_employee_map",
               joinColumns = @JoinColumn(name = "employer_id",
                                        referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "employee_id",
                                        referencedColumnName = "id"))
    private List<Employee> employee;


    @OneToOne(mappedBy = "employer", cascade = CascadeType.ALL)
    private Invoice invoice;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}
