package pl.edu.wszib.MyFreelancePal.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "Employer")
@Entity
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Notes", nullable = false)
    private String notes;
    @Column(name = "NIP", nullable = false)
    private String nip;
    @Column(name = "Phone")
    private String phone;
    @Email
    @Column(name = "Email")
    private String email;
    @Column(name = "ActiveEmployer")
    private Boolean active;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> address;

    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<Invoice> invoice;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}
