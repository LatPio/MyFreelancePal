package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceServiceEntryDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceServiceEntryDomain;

import java.util.List;

@Mapper(uses = {TaskMapperDTO.class})
public interface InvoiceServiceEntryMapperDTO {

    InvoiceServiceEntryDTO map(InvoiceServiceEntryDomain invoiceServiceEntryDomain);

    InvoiceServiceEntryDomain map(InvoiceServiceEntryDTO invoiceServiceEntryDTO);

    List<InvoiceServiceEntryDTO> mapToDTO(List<InvoiceServiceEntryDomain> invoiceServiceEntryDomains);

}
