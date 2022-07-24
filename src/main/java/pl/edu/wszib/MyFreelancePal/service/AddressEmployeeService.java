package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Address;
import pl.edu.wszib.MyFreelancePal.repository.AddressRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.AddressEmployeeDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.AddressEmployeeMapper;

import java.util.List;

@Service
public class AddressEmployeeService implements CrudService<AddressEmployeeDomain, Integer> {

    @Autowired
    private AddressRepository addressRepository;
    private AddressEmployeeMapper mapper = Mappers.getMapper(AddressEmployeeMapper.class);


    public List<AddressEmployeeDomain> list2(Integer id) {
        return mapper.mapToDomain(addressRepository.findByEmployee_id(id));
    }

    @Override
    public List<AddressEmployeeDomain> list() {
        return null;
    }

    @Override
    public AddressEmployeeDomain get(Integer integer) {
        return addressRepository.findById(integer)
                .map(address -> mapper.map(address))
                .orElse(null);
    }

    @Override
    public AddressEmployeeDomain create(AddressEmployeeDomain addressEmployeeDomain) {
        addressEmployeeDomain.setId(null);
        Address created =addressRepository.save(mapper.map(addressEmployeeDomain));
        return mapper.map(created);
    }

    @Override
    public AddressEmployeeDomain update(AddressEmployeeDomain addressEmployeeDomain) {
        AddressEmployeeDomain existing = get(addressEmployeeDomain.getId());
        if (existing == null) {
            return null;
        }
        Address updated = addressRepository.save(mapper.map(addressEmployeeDomain));
        return  mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        addressRepository.deleteById(integer);
    }
}
