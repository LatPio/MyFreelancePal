package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskInvoiceDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskInvoiceDomain;

import java.util.List;

@Mapper
public interface TaskInvoiceMapperDTO {

    @Mapping(target = "projectDTO", source = "projectDomain")
    TaskInvoiceDTO map(TaskInvoiceDomain taskInvoiceDomain);

    @Mapping(target = "projectDomain", source = "projectDTO")
    TaskInvoiceDomain map(TaskInvoiceDTO taskInvoiceDTO);

    List<TaskInvoiceDTO> mapToDTO(List<TaskInvoiceDomain> taskInvoiceDomains);

    List<TaskInvoiceDomain> mapToDomain(List<TaskInvoiceDTO> taskInvoiceDTOS);



}
