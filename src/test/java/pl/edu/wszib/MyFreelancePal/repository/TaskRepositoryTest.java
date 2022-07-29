package pl.edu.wszib.MyFreelancePal.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.wszib.MyFreelancePal.model.Task;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TaskRepositoryTest {

    public static final LocalDateTime START_DATE = LocalDateTime.of(2022,7,1,1,1);
    public static final LocalDateTime END_DATE = LocalDateTime.of(2022,8,1,1,1);
    @Autowired
    TaskRepository taskRepository;

    @BeforeEach
    void setUp() {

    }


    @Test
    void findByProject_Id() {
        Collection test = taskRepository.findByProject_Id(10001);
        assertNotNull(test, "Null? In DataBase are Tasks");
    }

    @Test
    void countAllByDoneTask() {
        Integer taskTest = taskRepository.countAllByDoneTask(true);
        assertEquals(taskTest, 28, "Counts don't match");
    }

    @Test
    void countByInvoiceCreatedFalse() {
        Long taskTest = taskRepository.countByInvoiceCreatedFalse();
        assertEquals(taskTest, 24, "Counts don't match");
    }

    @Test
    void totalMinutes() {
        Long test = taskRepository.totalMinutes();
        assertNotNull(test, "Null in DataBase are Tasks");
    }

    @Test
    void findTaskTestingForGrandparent() {
        Collection test = taskRepository.findTaskTestingForGrandparent(10001,true, false);
        assertNotNull(test, "Null? In DataBase are Tasks");
    }

    @Test
    void sumAmountByInvoiceCreated() {
        BigDecimal test = taskRepository.sumAmountByInvoiceCreated(START_DATE, END_DATE);
        assertNotNull(test, "Null? In DataBase are Tasks");
    }

    @Test
    void sumTimeByInvoiceCreated() {
        Long test = taskRepository.sumTimeByInvoiceCreated(START_DATE, END_DATE);
        assertEquals(test, 4120, "Null? In DataBase are Tasks");
    }
}