package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-14T21:36:42+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProjectMapperDTOImpl implements ProjectMapperDTO {

    @Override
    public ProjectDTO map(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        ProjectDTO.ProjectDTOBuilder projectDTO = ProjectDTO.builder();

        projectDTO.employerDTO( employerDomainToEmployerDTO( projectDomain.getEmployerDomain() ) );
        projectDTO.id( projectDomain.getId() );
        projectDTO.name( projectDomain.getName() );

        return projectDTO.build();
    }

    @Override
    public ProjectDomain map(ProjectDTO projectDTO) {
        if ( projectDTO == null ) {
            return null;
        }

        ProjectDomain.ProjectDomainBuilder projectDomain = ProjectDomain.builder();

        projectDomain.employerDomain( employerDTOToEmployerDomain( projectDTO.getEmployerDTO() ) );
        projectDomain.id( projectDTO.getId() );
        projectDomain.name( projectDTO.getName() );

        return projectDomain.build();
    }

    @Override
    public List<ProjectDTO> mapToDTO(List<ProjectDomain> projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        List<ProjectDTO> list = new ArrayList<ProjectDTO>( projectDomain.size() );
        for ( ProjectDomain projectDomain1 : projectDomain ) {
            list.add( map( projectDomain1 ) );
        }

        return list;
    }

    protected EmployerDTO employerDomainToEmployerDTO(EmployerDomain employerDomain) {
        if ( employerDomain == null ) {
            return null;
        }

        EmployerDTO.EmployerDTOBuilder employerDTO = EmployerDTO.builder();

        employerDTO.id( employerDomain.getId() );
        employerDTO.name( employerDomain.getName() );
        employerDTO.nip( employerDomain.getNip() );

        return employerDTO.build();
    }

    protected EmployerDomain employerDTOToEmployerDomain(EmployerDTO employerDTO) {
        if ( employerDTO == null ) {
            return null;
        }

        EmployerDomain.EmployerDomainBuilder employerDomain = EmployerDomain.builder();

        employerDomain.id( employerDTO.getId() );
        employerDomain.name( employerDTO.getName() );
        employerDomain.nip( employerDTO.getNip() );

        return employerDomain.build();
    }
}
