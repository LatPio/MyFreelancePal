package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-14T21:36:42+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class AddressEmployerMapperImpl implements AddressEmployerMapper {

    @Override
    public AddressEmployerDomain map(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEmployerDomain.AddressEmployerDomainBuilder addressEmployerDomain = AddressEmployerDomain.builder();

        addressEmployerDomain.id( address.getId() );
        addressEmployerDomain.name( address.getName() );
        addressEmployerDomain.street( address.getStreet() );
        addressEmployerDomain.postalCode( address.getPostalCode() );
        addressEmployerDomain.buildingNumber( address.getBuildingNumber() );
        addressEmployerDomain.flatNumber( address.getFlatNumber() );
        addressEmployerDomain.city( address.getCity() );
        addressEmployerDomain.country( address.getCountry() );
        addressEmployerDomain.employer( employerToEmployerDomain( address.getEmployer() ) );

        return addressEmployerDomain.build();
    }

    @Override
    public Address map(AddressEmployerDomain addressEmployerDomain) {
        if ( addressEmployerDomain == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.id( addressEmployerDomain.getId() );
        address.name( addressEmployerDomain.getName() );
        address.street( addressEmployerDomain.getStreet() );
        address.postalCode( addressEmployerDomain.getPostalCode() );
        address.buildingNumber( addressEmployerDomain.getBuildingNumber() );
        address.flatNumber( addressEmployerDomain.getFlatNumber() );
        address.city( addressEmployerDomain.getCity() );
        address.country( addressEmployerDomain.getCountry() );
        address.employer( employerDomainToEmployer( addressEmployerDomain.getEmployer() ) );

        return address.build();
    }

    @Override
    public List<AddressEmployerDomain> mapToDomain(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressEmployerDomain> list = new ArrayList<AddressEmployerDomain>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( map( address ) );
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
