package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.model.InvoiceServiceEntry;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceServiceEntryDomain;

import java.util.List;

@Mapper(uses = {TaskMapper.class})
public interface InvoiceServiceEntryMapper {

    InvoiceServiceEntry map(InvoiceServiceEntryDomain invoiceServiceEntryDomain);

    InvoiceServiceEntryDomain map(InvoiceServiceEntry invoiceServiceEntry);

    List<InvoiceServiceEntryDomain> mapToDomain(List<InvoiceServiceEntry> invoiceServiceEntries);
}
