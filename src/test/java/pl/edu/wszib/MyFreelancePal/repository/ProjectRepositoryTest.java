package pl.edu.wszib.MyFreelancePal.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProjectRepositoryTest {

    @Autowired
    ProjectRepository projectRepository;

    @Test
    void findByEmployer_Id() {
        Collection test = projectRepository.findByEmployer_Id(10001);
        assertNotNull(test, "Null? In DataBase are Project");
    }

    @Test
    void findByActiveProject() {
        Collection test = projectRepository.findByActiveProject(true);
        assertNotNull(test, "Null? In DataBase are Project");
    }

    @Test
    void countAllByActiveProject() {
        Integer test = projectRepository.countAllByActiveProject(true);
        assertEquals(test, 14, "Counts don't match!");
    }

    @Test
    void findByEmployer_Active() {
        Collection test = projectRepository.findByEmployer_Active(true);
        assertNotNull(test,"Null? In DataBase are Project");
    }
}