package pl.edu.wszib.MyFreelancePal.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class InvoiceServiceEntryRepositoryTest {

    @Autowired
    InvoiceServiceEntryRepository invoiceServiceEntryRepository;

    @Test
    void findAllByInvoice_Id() {
        Collection test = invoiceServiceEntryRepository.findAllByInvoice_Id("2022-07/10000");
        assertNotNull(test, "Null? In DataBase are Invoice Entries");

    }
}