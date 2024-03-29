package pl.edu.wszib.MyFreelancePal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.MyFreelancePal.model.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByEmployer_Id(Integer id);
    List<Project> findByActiveProject(boolean b);
    Integer countAllByActiveProject(boolean b);
    @Query("select p from Project p where p.employer.active = ?1")
    List<Project> findByEmployer_Active(Boolean active);

}
