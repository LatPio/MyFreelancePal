package pl.edu.wszib.MyFreelancePal.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EmployerRepositoryTest {

    @Autowired
    EmployerRepository employerRepository;

    @Test
    void findByActive() {
        Collection test = employerRepository.findByActive(true);
        assertNotNull(test, "Null? In DataBase are Employers");
    }
}