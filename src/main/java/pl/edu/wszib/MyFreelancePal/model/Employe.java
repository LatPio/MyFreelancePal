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
public class Employe {

    @ToString.Include
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;
    @ToString.Include
    private String name;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToMany(mappedBy = "employe", fetch = FetchType.LAZY)
    private List<Address> addresses;

}
