package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.model.Task;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-01T20:01:26+0200",
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
        taskDomain.dateStart( task.getDateStart() );
        taskDomain.dateEnd( task.getDateEnd() );

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

    protected ProjectDomain projectToProjectDomain(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDomain.ProjectDomainBuilder projectDomain = ProjectDomain.builder();

        projectDomain.id( project.getId() );
        projectDomain.name( project.getName() );

        return projectDomain.build();
    }

    protected Project projectDomainToProject(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.id( projectDomain.getId() );
        project.name( projectDomain.getName() );

        return project.build();
    }
}
