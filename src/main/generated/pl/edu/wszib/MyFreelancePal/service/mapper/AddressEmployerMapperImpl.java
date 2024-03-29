package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.model.Employer;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.EmployerDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-24T11:36:55+0200",
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

        Address address = new Address();

        address.setId( addressEmployerDomain.getId() );
        address.setName( addressEmployerDomain.getName() );
        address.setStreet( addressEmployerDomain.getStreet() );
        address.setPostalCode( addressEmployerDomain.getPostalCode() );
        address.setBuildingNumber( addressEmployerDomain.getBuildingNumber() );
        address.setFlatNumber( addressEmployerDomain.getFlatNumber() );
        address.setCity( addressEmployerDomain.getCity() );
        address.setCountry( addressEmployerDomain.getCountry() );
        address.setEmployer( employerDomainToEmployer( addressEmployerDomain.getEmployer() ) );

        return address;
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
