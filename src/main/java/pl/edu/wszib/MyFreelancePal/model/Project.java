package pl.edu.wszib.MyFreelancePal.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "Project")
@Entity
public class    Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(nullable = true)
    private String color;
    private String description;
    @Column(nullable = true)
    private Boolean activeProject = true;
    @Column(nullable = true)
    private BigDecimal hourPriceDefault = BigDecimal.valueOf(0);
    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;


    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;




}
