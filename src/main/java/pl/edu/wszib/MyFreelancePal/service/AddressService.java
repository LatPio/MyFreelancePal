package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.repository.AddressRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.AddressMapper;

import java.util.List;

public class AddressService implements CrudService<AddressDomain, Integer> {

    @Autowired
    private AddressRepository addressRepository;

    private AddressMapper mapper = Mappers.getMapper(AddressMapper.class);

    @Override
    public List<AddressDomain> list() {
        return mapper.mapToDomain(addressRepository.findAll());
    }

    @Override
    public AddressDomain get(Integer integer) {
        return addressRepository.findById(integer)
                .map(address -> mapper.map(address))
                .orElse(null);
    }

    @Override
    public AddressDomain create(AddressDomain addressDomain) {
        addressDomain.setId(null);
        Address created =addressRepository.save(mapper.map(addressDomain));
        return mapper.map(created);
    }

    @Override
    public AddressDomain update(AddressDomain addressDomain) {
        AddressDomain existing = get(addressDomain.getId());
        if (existing == null) {
            return null;
        }
        Address updated = addressRepository.save(mapper.map(addressDomain));
        return  mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        addressRepository.deleteById(integer);
    }
}
