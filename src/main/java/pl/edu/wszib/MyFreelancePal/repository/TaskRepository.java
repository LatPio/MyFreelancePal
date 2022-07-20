package pl.edu.wszib.MyFreelancePal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.MyFreelancePal.model.Task;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByProject_Id(Integer id);

    Integer countAllByDoneTask(boolean b);

    @Query(value = "SELECT sum(timeOfWorkInMin) from Task")
    public Long totalMinutes();

    @Query(nativeQuery = true, value = "SELECT sum(timeOfWorkInMin) from Task where invoiceserviceentryid ?")
    public Long totalMinutesByID(Integer id);
    List<Task> findTasksByDoneTaskAndInvoiceCreatedAndProjectEmployerContains(boolean b, boolean a, Integer id);

    @Query("""
            select t from Task t
            where t.project.employer.id = :id and t.doneTask = :doneTask and t.invoiceCreated = :invoiceCreated""")
    List<Task> findTaskTestingForGrandparent(@Param("id") Integer id, @Param("doneTask") Boolean doneTask, @Param("invoiceCreated") Boolean invoiceCreated);




}
