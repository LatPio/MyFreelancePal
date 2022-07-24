package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Invoice;
import pl.edu.wszib.MyFreelancePal.repository.InvoiceRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.InvoiceMapper;

import java.util.List;

@Service
public class InvoiceService implements CrudService<InvoiceDomain, String> {

    @Autowired
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper mapper = Mappers.getMapper(InvoiceMapper.class);

    @Override
    public List<InvoiceDomain> list() {
        return mapper.mapToDomain(invoiceRepository.findAll());
    }

    public Long countInvoices() {return invoiceRepository.countByIdNotNull();}

    @Override
    public InvoiceDomain get(String string) {
        return invoiceRepository.findById(string)
                .map(invoice -> mapper.map(invoice))
                .orElse(null);
    }

    @Override
    public InvoiceDomain create(InvoiceDomain invoiceDomain) {
        invoiceDomain.setId(null);
        Invoice created = invoiceRepository.save(mapper.map(invoiceDomain));
        return mapper.map(created);
    }

    @Override
    public InvoiceDomain update(InvoiceDomain invoiceDomain) {
        InvoiceDomain existing = get(invoiceDomain.getId());
        if (existing == null){
            return null;
        }
        Invoice updated = invoiceRepository.save(mapper.map(invoiceDomain));
        return mapper.map(updated);
    }

    @Override
    public void delete(String string) {
        invoiceRepository.deleteById(string);
    }
}
