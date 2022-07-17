package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.InvoiceServiceEntry;
import pl.edu.wszib.MyFreelancePal.repository.InvoiceServiceEntryRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceServiceEntryDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.InvoiceServiceEntryMapper;

import java.util.List;

@Service
public class InvoiceServiceEntryService implements CrudService<InvoiceServiceEntryDomain, Integer> {

    @Autowired
    private InvoiceServiceEntryRepository invoiceServiceEntryRepository;

    private InvoiceServiceEntryMapper mapper = Mappers.getMapper(InvoiceServiceEntryMapper.class);

    @Override
    public List<InvoiceServiceEntryDomain> list() {
        return mapper.mapToDomain(invoiceServiceEntryRepository.findAll());
    }

    public List<InvoiceServiceEntryDomain> listByInvoice(Integer id){
        return mapper.mapToDomain(invoiceServiceEntryRepository.findAllByInvoice_Id(id));
    }


    @Override
    public InvoiceServiceEntryDomain get(Integer integer) {
        return invoiceServiceEntryRepository.findById(integer).map(invoiceServiceEntry -> mapper.map(invoiceServiceEntry)).orElse(null);
    }

    @Override
    public InvoiceServiceEntryDomain create(InvoiceServiceEntryDomain invoiceServiceEntryDomain) {
        invoiceServiceEntryDomain.setId(null);
        InvoiceServiceEntry created = invoiceServiceEntryRepository.save(mapper.map(invoiceServiceEntryDomain));
        return mapper.map(created);
    }

    @Override
    public InvoiceServiceEntryDomain update(InvoiceServiceEntryDomain invoiceServiceEntryDomain) {
        InvoiceServiceEntryDomain existing = get(invoiceServiceEntryDomain.getId());
        if(existing == null) {
            return null;
        }
        InvoiceServiceEntry updated = invoiceServiceEntryRepository.save(mapper.map(invoiceServiceEntryDomain));


        return mapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        invoiceServiceEntryRepository.deleteById(integer);

    }
}
