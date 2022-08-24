package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.model.Project;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-24T11:36:54+0200",
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
        projectDomain.color( project.getColor() );
        projectDomain.hourPriceDefault( project.getHourPriceDefault() );

        return projectDomain.build();
    }

    @Override
    public Project map(ProjectDomain projectDomain) {
        if ( projectDomain == null ) {
            return null;
        }

        Project project = new Project();

        project.setEmployer( employerDomainToEmployer( projectDomain.getEmployerDomain() ) );
        project.setId( projectDomain.getId() );
        project.setName( projectDomain.getName() );
        project.setColor( projectDomain.getColor() );
        project.setHourPriceDefault( projectDomain.getHourPriceDefault() );

        return project;
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

        return employerDomain.build();
    }

    protected Employer employerDomainToEmployer(EmployerDomain employerDomain) {
        if ( employerDomain == null ) {
            return null;
        }

        Employer employer = new Employer();

        employer.setId( employerDomain.getId() );
        employer.setName( employerDomain.getName() );

        return employer;
    }
}
