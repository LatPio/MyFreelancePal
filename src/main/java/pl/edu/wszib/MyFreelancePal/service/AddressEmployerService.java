package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.repository.AddressRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployerDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.AddressEmployerMapper;

import java.util.List;

@Service
public class AddressEmployerService implements CrudService<AddressEmployerDomain, Integer> {

    @Autowired
    private AddressRepository addressRepository;

    private AddressEmployerMapper mapper = Mappers.getMapper(AddressEmployerMapper.class);

    @Override
    public List<AddressEmployerDomain> list() {
        return mapper.mapToDomain(addressRepository.findAll());
    }

    @Override
    public AddressEmployerDomain get(Integer integer) {
        return addressRepository.findById(integer)
                .map(address -> mapper.map(address))
                .orElse(null);
    }

    @Override
    public AddressEmployerDomain create(AddressEmployerDomain addressEmployerDomain) {
        addressEmployerDomain.setId(null);
        Address created =addressRepository.save(mapper.map(addressEmployerDomain));
        return mapper.map(created);
    }

    @Override
    public AddressEmployerDomain update(AddressEmployerDomain addressEmployerDomain) {
        AddressEmployerDomain existing = get(addressEmployerDomain.getId());
        if (existing == null) {
            return null;
        }
        Address updated = addressRepository.save(mapper.map(addressEmployerDomain));
        return  mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        addressRepository.deleteById(integer);
    }
}
