package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.EmployeeDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployeeDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-30T12:46:28+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployeeMapperDTOImpl implements EmployeeMapperDTO {

    @Override
    public EmployeeDTO map(EmployeeDomain employeeDomain) {
        if ( employeeDomain == null ) {
            return null;
        }

        EmployeeDTO.EmployeeDTOBuilder employeeDTO = EmployeeDTO.builder();

        employeeDTO.id( employeeDomain.getId() );
        employeeDTO.name( employeeDomain.getName() );

        return employeeDTO.build();
    }

    @Override
    public EmployeeDomain map(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        EmployeeDomain.EmployeeDomainBuilder employeeDomain = EmployeeDomain.builder();

        employeeDomain.id( employeeDTO.getId() );
        employeeDomain.name( employeeDTO.getName() );

        return employeeDomain.build();
    }

    @Override
    public List<EmployeeDTO> mapToDTO(List<EmployeeDomain> employeeDomains) {
        if ( employeeDomains == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( employeeDomains.size() );
        for ( EmployeeDomain employeeDomain : employeeDomains ) {
            list.add( map( employeeDomain ) );
        }

        return list;
    }
}
