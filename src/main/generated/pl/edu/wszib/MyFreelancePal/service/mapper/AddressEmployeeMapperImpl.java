package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-04T11:04:39+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class AddressEmployeeMapperImpl implements AddressEmployeeMapper {

    @Override
    public AddressEmployeeDomain map(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEmployeeDomain.AddressEmployeeDomainBuilder addressEmployeeDomain = AddressEmployeeDomain.builder();

        addressEmployeeDomain.id( address.getId() );
        addressEmployeeDomain.name( address.getName() );
        addressEmployeeDomain.street( address.getStreet() );
        addressEmployeeDomain.postalCode( address.getPostalCode() );
        addressEmployeeDomain.buildingNumber( address.getBuildingNumber() );
        addressEmployeeDomain.flatNumber( address.getFlatNumber() );
        addressEmployeeDomain.city( address.getCity() );
        addressEmployeeDomain.country( address.getCountry() );

        return addressEmployeeDomain.build();
    }

    @Override
    public Address map(AddressEmployeeDomain addressEmployeeDomain) {
        if ( addressEmployeeDomain == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.id( addressEmployeeDomain.getId() );
        address.name( addressEmployeeDomain.getName() );
        address.street( addressEmployeeDomain.getStreet() );
        address.postalCode( addressEmployeeDomain.getPostalCode() );
        address.buildingNumber( addressEmployeeDomain.getBuildingNumber() );
        address.flatNumber( addressEmployeeDomain.getFlatNumber() );
        address.city( addressEmployeeDomain.getCity() );
        address.country( addressEmployeeDomain.getCountry() );

        return address.build();
    }

    @Override
    public List<AddressEmployeeDomain> mapToDomain(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressEmployeeDomain> list = new ArrayList<AddressEmployeeDomain>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( map( address ) );
        }

        return list;
    }
}
