package pl.edu.wszib.MyFreelancePal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.MyFreelancePal.model.Task;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByProject_Id(Integer id);

    Integer countAllByDoneTask(boolean b);

    @Query(value = "SELECT sum(timeOfWorkInMin) from Task")
    public Long totalMinutes();

    List<Task> findTasksByDoneTaskAndInvoiceCreatedAndProjectId(boolean b, boolean a, Integer id);
}
