package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.Event;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-25T23:57:26+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EventMapperImpl implements EventMapper {

    @Override
    public Event map(TaskDomain taskDomain) {
        if ( taskDomain == null ) {
            return null;
        }

        Event event = new Event();

        event.setTitle( taskDomain.getName() );
        event.setStart( taskDomain.getDateStart() );
        event.setEnd( taskDomain.getDateEnd() );
        event.setColor( taskDomainProjectDomainColor( taskDomain ) );

        return event;
    }

    @Override
    public TaskDomain map(Event event) {
        if ( event == null ) {
            return null;
        }

        TaskDomain.TaskDomainBuilder taskDomain = TaskDomain.builder();

        taskDomain.projectDomain( eventToProjectDomain( event ) );
        taskDomain.name( event.getTitle() );
        taskDomain.dateStart( event.getStart() );
        taskDomain.dateEnd( event.getEnd() );

        return taskDomain.build();
    }

    @Override
    public List<Event> mapToDTO(List<TaskDomain> taskDomains) {
        if ( taskDomains == null ) {
            return null;
        }

        List<Event> list = new ArrayList<Event>( taskDomains.size() );
        for ( TaskDomain taskDomain : taskDomains ) {
            list.add( map( taskDomain ) );
        }

        return list;
    }

    private String taskDomainProjectDomainColor(TaskDomain taskDomain) {
        if ( taskDomain == null ) {
            return null;
        }
        ProjectDomain projectDomain = taskDomain.getProjectDomain();
        if ( projectDomain == null ) {
            return null;
        }
        String color = projectDomain.getColor();
        if ( color == null ) {
            return null;
        }
        return color;
    }

    protected ProjectDomain eventToProjectDomain(Event event) {
        if ( event == null ) {
            return null;
        }

        ProjectDomain.ProjectDomainBuilder projectDomain = ProjectDomain.builder();

        projectDomain.color( event.getColor() );

        return projectDomain.build();
    }
}
