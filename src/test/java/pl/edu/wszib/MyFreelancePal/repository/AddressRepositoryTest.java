package pl.edu.wszib.MyFreelancePal.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    @Test
    void findByEmployee_id() {
        Collection test = addressRepository.findByEmployee_id(10001);
        assertNotNull(test, "Null? In DataBase are Addresses");
    }

    @Test
    void findByEmployer_id() {
        Collection test = addressRepository.findByEmployer_id(10001);
        assertNotNull(test, "Null? In DataBase are Addresses");
    }
}