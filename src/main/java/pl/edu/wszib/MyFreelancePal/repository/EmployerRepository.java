package pl.edu.wszib.MyFreelancePal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.MyFreelancePal.model.Employe;

import java.util.List;

@Repository
public interface EmployerRepository extends JpaRepository<Employe, Integer> {

    List<Employe> findAllByName (String name);
}
