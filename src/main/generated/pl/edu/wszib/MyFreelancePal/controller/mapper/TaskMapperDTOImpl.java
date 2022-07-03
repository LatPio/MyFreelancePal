package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-03T14:49:36+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
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
        taskDomain.dateStart( taskDTO.getDateStart() );
        taskDomain.dateEnd( taskDTO.getDateEnd() );

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

    protected ProjectDTO projectDomainToProjectDTO(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        ProjectDTO.ProjectDTOBuilder projectDTO = ProjectDTO.builder();

        projectDTO.id( projectDomain.getId() );
        projectDTO.name( projectDomain.getName() );

        return projectDTO.build();
    }

    protected ProjectDomain projectDTOToProjectDomain(ProjectDTO projectDTO) {
        if ( projectDTO == null ) {
            return null;
        }

        ProjectDomain.ProjectDomainBuilder projectDomain = ProjectDomain.builder();

        projectDomain.id( projectDTO.getId() );
        projectDomain.name( projectDTO.getName() );

        return projectDomain.build();
    }
}
