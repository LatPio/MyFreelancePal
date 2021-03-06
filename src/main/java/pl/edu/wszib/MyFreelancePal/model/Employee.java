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
@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    private String name;
    private String nip;
    private String bankNumber;
    private String bankIban;


    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Address> address;

//    @ManyToMany(mappedBy = "employee", fetch = FetchType.LAZY)
//    private List<Employer> employer;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Invoice> invoice;


    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}
