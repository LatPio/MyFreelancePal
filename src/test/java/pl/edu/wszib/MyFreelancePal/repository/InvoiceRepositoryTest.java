package pl.edu.wszib.MyFreelancePal.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Test
    void countByIdNotNull() {
        Long taskTest = invoiceRepository.countByIdNotNull();
        assertEquals(taskTest, 1, "Counts don't match");
    }
}