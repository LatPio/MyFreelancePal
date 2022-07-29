package pl.edu.wszib.MyFreelancePal.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Employee")
@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "NIP", nullable = false)
    private String nip;
    @Column(name = "VAT", nullable = false)
    private Integer vat;
    @Column(name = "Currency")
    private String currency;
    @Column(name = "Description")
    private String description;
    @Column(name = "Phone")
    private String phone;
    @Email
    @Column(name = "Email")
    private String email;
    @Column(name = "BankNumber")
    private String bankNumber;
    @Column(name = "BankIban")
    private String bankIban;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> address;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Invoice> invoice;

    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
}
