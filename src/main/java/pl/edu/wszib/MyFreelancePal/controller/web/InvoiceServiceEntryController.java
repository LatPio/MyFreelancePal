package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.MyFreelancePal.controller.mapper.InvoiceServiceEntryMapperDTO;
import pl.edu.wszib.MyFreelancePal.model.InvoiceServiceEntry;
import pl.edu.wszib.MyFreelancePal.service.InvoiceServiceEntryService;

@Controller
@RequestMapping("/inoice-entry")
public class InvoiceServiceEntryController {
    @Autowired
    private InvoiceServiceEntryService invoiceServiceEntryService;

    private InvoiceServiceEntryMapperDTO invoiceServiceEntryMapperDTO = Mappers.getMapper(InvoiceServiceEntryMapperDTO.class);



}
