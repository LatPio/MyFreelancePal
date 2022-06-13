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
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToMany(mappedBy = "employer", fetch = FetchType.LAZY)
    private List<Address> address;

    @OneToMany(mappedBy = "employers", fetch = FetchType.LAZY)
    private List<Project> projects;

}
