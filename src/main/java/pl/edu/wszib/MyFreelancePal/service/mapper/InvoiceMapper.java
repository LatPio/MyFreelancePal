package pl.edu.wszib.MyFreelancePal.service.mapper;


import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.model.Invoice;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;

import java.util.List;

@Mapper
public interface InvoiceMapper {

    InvoiceDomain map(Invoice invoice);
    Invoice map(InvoiceDomain invoiceDomain);
    List<InvoiceDomain> mapToDomain(List<Invoice> invoice);
}
