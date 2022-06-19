package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;

import java.util.List;

@Mapper
public interface InvoiceMapperDTO {

    InvoiceDTO map(InvoiceDomain invoiceDomain);
    InvoiceDomain map(InvoiceDTO invoiceDTO);
    List<InvoiceDTO> mapToDTO(List<InvoiceDomain> invoiceDomain);
}
