package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-24T11:36:55+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TaskMapperDTOImpl implements TaskMapperDTO {

    @Override
    public TaskDTO map(TaskDomain taskDomain) {
        if ( taskDomain == null ) {
            return null;
        }

        TaskDTO.TaskDTOBuilder taskDTO = TaskDTO.builder();

        taskDTO.projectDTO( projectDomainToProjectDTO( taskDomain.getProjectDomain() ) );
        taskDTO.id( taskDomain.getId() );
        taskDTO.name( taskDomain.getName() );
        taskDTO.dateStart( taskDomain.getDateStart() );
        taskDTO.dateEnd( taskDomain.getDateEnd() );
        taskDTO.invoiceCreated( taskDomain.getInvoiceCreated() );
        taskDTO.hourPrice( taskDomain.getHourPrice() );
        taskDTO.timeOfWorkInMin( taskDomain.getTimeOfWorkInMin() );
        taskDTO.doneTask( taskDomain.getDoneTask() );

        return taskDTO.build();
    }

    @Override
    public TaskDomain map(TaskDTO taskDTO) {
        if ( taskDTO == null ) {
            return null;
        }

        TaskDomain.TaskDomainBuilder taskDomain = TaskDomain.builder();

        taskDomain.projectDomain( projectDTOToProjectDomain( taskDTO.getProjectDTO() ) );
        taskDomain.id( taskDTO.getId() );
        taskDomain.name( taskDTO.getName() );
        taskDomain.timeOfWorkInMin( taskDTO.getTimeOfWorkInMin() );
        taskDomain.dateStart( taskDTO.getDateStart() );
        taskDomain.dateEnd( taskDTO.getDateEnd() );
        taskDomain.doneTask( taskDTO.getDoneTask() );
        taskDomain.invoiceCreated( taskDTO.getInvoiceCreated() );
        taskDomain.hourPrice( taskDTO.getHourPrice() );

        return taskDomain.build();
    }

    @Override
    public List<TaskDTO> mapToDTO(List<TaskDomain> taskDomains) {
        if ( taskDomains == null ) {
            return null;
        }

        List<TaskDTO> list = new ArrayList<TaskDTO>( taskDomains.size() );
        for ( TaskDomain taskDomain : taskDomains ) {
            list.add( map( taskDomain ) );
        }

        return list;
    }

    @Override
    public List<TaskDomain> mapToDomain(List<TaskDTO> taskDTOS) {
        if ( taskDTOS == null ) {
            return null;
        }

        List<TaskDomain> list = new ArrayList<TaskDomain>( taskDTOS.size() );
        for ( TaskDTO taskDTO : taskDTOS ) {
            list.add( map( taskDTO ) );
        }

        return list;
    }

    protected ProjectDTO projectDomainToProjectDTO(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        ProjectDTO.ProjectDTOBuilder projectDTO = ProjectDTO.builder();

        projectDTO.id( projectDomain.getId() );
        projectDTO.name( projectDomain.getName() );
        projectDTO.hourPriceDefault( projectDomain.getHourPriceDefault() );

        return projectDTO.build();
    }

    protected ProjectDomain projectDTOToProjectDomain(ProjectDTO projectDTO) {
        if ( projectDTO == null ) {
            return null;
        }

        ProjectDomain.ProjectDomainBuilder projectDomain = ProjectDomain.builder();

        projectDomain.id( projectDTO.getId() );
        projectDomain.name( projectDTO.getName() );
        projectDomain.hourPriceDefault( projectDTO.getHourPriceDefault() );

        return projectDomain.build();
    }
}
