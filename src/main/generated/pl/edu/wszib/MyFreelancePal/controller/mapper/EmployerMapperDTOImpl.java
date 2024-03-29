package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-24T11:36:55+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployerMapperDTOImpl implements EmployerMapperDTO {

    @Override
    public EmployerDTO map(EmployerDomain employerDomain) {
        if ( employerDomain == null ) {
            return null;
        }

        EmployerDTO.EmployerDTOBuilder employerDTO = EmployerDTO.builder();

        employerDTO.id( employerDomain.getId() );
        employerDTO.name( employerDomain.getName() );

        return employerDTO.build();
    }

    @Override
    public EmployerDomain map(EmployerDTO employerDTO) {
        if ( employerDTO == null ) {
            return null;
        }

        EmployerDomain.EmployerDomainBuilder employerDomain = EmployerDomain.builder();

        employerDomain.id( employerDTO.getId() );
        employerDomain.name( employerDTO.getName() );

        return employerDomain.build();
    }

    @Override
    public List<EmployerDTO> mapToDTO(List<EmployerDomain> employerDomains) {
        if ( employerDomains == null ) {
            return null;
        }

        List<EmployerDTO> list = new ArrayList<EmployerDTO>( employerDomains.size() );
        for ( EmployerDomain employerDomain : employerDomains ) {
            list.add( map( employerDomain ) );
        }

        return list;
    }
}
