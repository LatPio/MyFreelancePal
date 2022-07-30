package pl.edu.wszib.MyFreelancePal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.MyFreelancePal.model.Task;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByProject_Id(Integer id);
    Integer countAllByDoneTask(boolean doneTask);
    Long countByInvoiceCreatedFalse();

    @Query(value = "SELECT sum(timeOfWorkInMin) from Task")
    Long totalMinutes();

     @Query("select t from Task t where t.project.employer.id = :id and t.doneTask = :doneTask and t.invoiceCreated = :invoiceCreated")
    List<Task> findTaskTestingForGrandparent(@Param("id") Integer id, @Param("doneTask") Boolean doneTask, @Param("invoiceCreated") Boolean invoiceCreated);

    @Query("select sum(hourPrice * timeOfWorkInMin / 60) from Task where dateStart between ?1 and ?2")
    BigDecimal sumAmountByInvoiceCreated(LocalDateTime startDate, LocalDateTime endDate);

    @Query("select sum(timeOfWorkInMin) from Task where dateStart between ?1 and ?2")
    Long sumTimeByInvoiceCreated(LocalDateTime startDate, LocalDateTime endDate);







}
