package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.model.Task;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-24T11:36:55+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDomain map(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDomain.TaskDomainBuilder taskDomain = TaskDomain.builder();

        taskDomain.projectDomain( projectToProjectDomain( task.getProject() ) );
        taskDomain.id( task.getId() );
        taskDomain.name( task.getName() );
        taskDomain.timeOfWorkInMin( task.getTimeOfWorkInMin() );
        taskDomain.dateStart( task.getDateStart() );
        taskDomain.dateEnd( task.getDateEnd() );
        taskDomain.doneTask( task.getDoneTask() );
        taskDomain.invoiceCreated( task.getInvoiceCreated() );
        taskDomain.hourPrice( task.getHourPrice() );

        return taskDomain.build();
    }

    @Override
    public Task map(TaskDomain taskDomain) {
        if ( taskDomain == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.project( projectDomainToProject( taskDomain.getProjectDomain() ) );
        task.id( taskDomain.getId() );
        task.name( taskDomain.getName() );
        task.dateStart( taskDomain.getDateStart() );
        task.dateEnd( taskDomain.getDateEnd() );
        task.timeOfWorkInMin( taskDomain.getTimeOfWorkInMin() );
        task.invoiceCreated( taskDomain.getInvoiceCreated() );
        task.doneTask( taskDomain.getDoneTask() );
        task.hourPrice( taskDomain.getHourPrice() );

        return task.build();
    }

    @Override
    public List<TaskDomain> mapToDomain(List<Task> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<TaskDomain> list = new ArrayList<TaskDomain>( tasks.size() );
        for ( Task task : tasks ) {
            list.add( map( task ) );
        }

        return list;
    }

    @Override
    public List<Task> mapToTasks(List<TaskDomain> taskDomains) {
        if ( taskDomains == null ) {
            return null;
        }

        List<Task> list = new ArrayList<Task>( taskDomains.size() );
        for ( TaskDomain taskDomain : taskDomains ) {
            list.add( map( taskDomain ) );
        }

        return list;
    }

    protected ProjectDomain projectToProjectDomain(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDomain.ProjectDomainBuilder projectDomain = ProjectDomain.builder();

        projectDomain.id( project.getId() );
        projectDomain.name( project.getName() );
        projectDomain.color( project.getColor() );
        projectDomain.hourPriceDefault( project.getHourPriceDefault() );

        return projectDomain.build();
    }

    protected Project projectDomainToProject(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectDomain.getId() );
        project.setName( projectDomain.getName() );
        project.setColor( projectDomain.getColor() );
        project.setHourPriceDefault( projectDomain.getHourPriceDefault() );

        return project;
    }
}
