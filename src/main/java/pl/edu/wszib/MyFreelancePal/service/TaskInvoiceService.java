package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Task;
import pl.edu.wszib.MyFreelancePal.repository.TaskRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskInvoiceDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.TaskInvoiceMapper;

import java.util.List;

@Service
public class TaskInvoiceService implements CrudService<TaskInvoiceDomain, Integer> {

    @Autowired
    private TaskRepository taskRepository;

    private TaskInvoiceMapper mapper = Mappers.getMapper(TaskInvoiceMapper.class);

    @Override
    public List<TaskInvoiceDomain> list() {
        return mapper.mapToDomain(taskRepository.findAll());
    }

    public List<TaskInvoiceDomain> listByProjectID(Integer id){
        return mapper.mapToDomain(taskRepository.findByProject_Id(id));
    }
    public List<TaskInvoiceDomain> findTaskTestingForGrandparent(Integer idOFEmployer, Boolean doneTask, Boolean invoiceCreated){
        return mapper.mapToDomain(taskRepository.findTaskTestingForGrandparent(idOFEmployer, doneTask, invoiceCreated));
    }

    @Override
    public TaskInvoiceDomain get(Integer integer) {
        return taskRepository.findById(integer)
                .map(task -> mapper.map(task))
                .orElse(null);
    }

    @Override
    public TaskInvoiceDomain create(TaskInvoiceDomain taskInvoiceDomain) {
        taskInvoiceDomain.setId(null);
        Task created = taskRepository.save(mapper.map(taskInvoiceDomain));
        return mapper.map(created);
    }

    @Override
    public TaskInvoiceDomain update(TaskInvoiceDomain taskInvoiceDomain) {
        TaskInvoiceDomain existing = get(taskInvoiceDomain.getId());
        if(existing == null) {
            return null;
        }
        Task updated = taskRepository.save(mapper.map(taskInvoiceDomain));
        return mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        taskRepository.deleteById(integer);
    }
}
