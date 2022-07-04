package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-04T11:04:38+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDomain map(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDomain.ProjectDomainBuilder projectDomain = ProjectDomain.builder();

        projectDomain.employerDomain( employerToEmployerDomain( project.getEmployer() ) );
        projectDomain.id( project.getId() );
        projectDomain.name( project.getName() );

        return projectDomain.build();
    }

    @Override
    public Project map(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.employer( employerDomainToEmployer( projectDomain.getEmployerDomain() ) );
        project.id( projectDomain.getId() );
        project.name( projectDomain.getName() );

        return project.build();
    }

    @Override
    public List<ProjectDomain> mapToDomain(List<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        List<ProjectDomain> list = new ArrayList<ProjectDomain>( projects.size() );
        for ( Project project : projects ) {
            list.add( map( project ) );
        }

        return list;
    }

    protected EmployerDomain employerToEmployerDomain(Employer employer) {
        if ( employer == null ) {
            return null;
        }

        EmployerDomain.EmployerDomainBuilder employerDomain = EmployerDomain.builder();

        employerDomain.id( employer.getId() );
        employerDomain.name( employer.getName() );
        employerDomain.nip( employer.getNip() );

        return employerDomain.build();
    }

    protected Employer employerDomainToEmployer(EmployerDomain employerDomain) {
        if ( employerDomain == null ) {
            return null;
        }

        Employer.EmployerBuilder employer = Employer.builder();

        employer.id( employerDomain.getId() );
        employer.name( employerDomain.getName() );
        employer.nip( employerDomain.getNip() );

        return employer.build();
    }
}
