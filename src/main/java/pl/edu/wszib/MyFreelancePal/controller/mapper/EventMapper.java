package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.edu.wszib.MyFreelancePal.controller.dto.Event;
import pl.edu.wszib.MyFreelancePal.service.domain.TaskDomain;

import java.util.List;

@Mapper(uses = {ProjectMapperDTO.class})
public interface EventMapper {

    @Mapping(target = "title", source = "name")
    @Mapping(target = "start", source = "dateStart")
    @Mapping(target = "end", source = "dateEnd")
    @Mapping(target = "color", source = "projectDomain.color")
    Event map(TaskDomain taskDomain);

    @Mapping(target = "name", source = "title")
    @Mapping(target = "dateStart", source = "start")
    @Mapping(target = "dateEnd", source = "end")
    @Mapping(target = "projectDomain.color", source = "color")
    TaskDomain map(Event event);

    List<Event> mapToDTO(List<TaskDomain> taskDomains);

}
