package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployerDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-03T14:49:36+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployerMapperDTOImpl implements EmployerMapperDTO {

    @Override
    public EmployerDTO map(EmployerDomain employerDomain) {
        if ( employerDomain == null ) {
            return null;
        }

        EmployerDTO.EmployerDTOBuilder employerDTO = EmployerDTO.builder();

        employerDTO.employeeDTO( employeeDomainListToEmployeeDTOList( employerDomain.getEmployeeDomain() ) );
        employerDTO.id( employerDomain.getId() );
        employerDTO.name( employerDomain.getName() );
        employerDTO.nip( employerDomain.getNip() );

        return employerDTO.build();
    }

    @Override
    public EmployerDomain map(EmployerDTO employerDTO) {
        if ( employerDTO == null ) {
            return null;
        }

        EmployerDomain.EmployerDomainBuilder employerDomain = EmployerDomain.builder();

        employerDomain.employeeDomain( employeeDTOListToEmployeeDomainList( employerDTO.getEmployeeDTO() ) );
        employerDomain.id( employerDTO.getId() );
        employerDomain.name( employerDTO.getName() );
        employerDomain.nip( employerDTO.getNip() );

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

    protected EmployeeDTO employeeDomainToEmployeeDTO(EmployeeDomain employeeDomain) {
        if ( employeeDomain == null ) {
            return null;
        }

        EmployeeDTO.EmployeeDTOBuilder employeeDTO = EmployeeDTO.builder();

        employeeDTO.id( employeeDomain.getId() );
        employeeDTO.name( employeeDomain.getName() );
        employeeDTO.nip( employeeDomain.getNip() );

        return employeeDTO.build();
    }

    protected List<EmployeeDTO> employeeDomainListToEmployeeDTOList(List<EmployeeDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployeeDTO> list1 = new ArrayList<EmployeeDTO>( list.size() );
        for ( EmployeeDomain employeeDomain : list ) {
            list1.add( employeeDomainToEmployeeDTO( employeeDomain ) );
        }

        return list1;
    }

    protected EmployeeDomain employeeDTOToEmployeeDomain(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        EmployeeDomain.EmployeeDomainBuilder employeeDomain = EmployeeDomain.builder();

        employeeDomain.id( employeeDTO.getId() );
        employeeDomain.name( employeeDTO.getName() );
        employeeDomain.nip( employeeDTO.getNip() );

        return employeeDomain.build();
    }

    protected List<EmployeeDomain> employeeDTOListToEmployeeDomainList(List<EmployeeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployeeDomain> list1 = new ArrayList<EmployeeDomain>( list.size() );
        for ( EmployeeDTO employeeDTO : list ) {
            list1.add( employeeDTOToEmployeeDomain( employeeDTO ) );
        }

        return list1;
    }
}
