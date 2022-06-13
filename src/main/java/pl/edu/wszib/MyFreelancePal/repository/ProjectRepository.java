package pl.edu.wszib.MyFreelancePal.repository;

import org.apache.tomcat.jni.Proc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.MyFreelancePal.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
