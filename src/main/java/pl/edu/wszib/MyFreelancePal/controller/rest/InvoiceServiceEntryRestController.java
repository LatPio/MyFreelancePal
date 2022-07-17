package pl.edu.wszib.MyFreelancePal.controller.rest;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceServiceEntryDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.InvoiceServiceEntryMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.InvoiceServiceEntryService;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceServiceEntryDomain;

import java.util.List;

@RestController
@RequestMapping("rest/invoiceServiceEntry")
public class InvoiceServiceEntryRestController {

    @Autowired
    private InvoiceServiceEntryService invoiceServiceEntryService;

    private InvoiceServiceEntryMapperDTO invoiceServiceEntryMapperDTO = Mappers.getMapper(InvoiceServiceEntryMapperDTO.class);


    @GetMapping("/list")
    public List<InvoiceServiceEntryDTO> list()

    {return invoiceServiceEntryMapperDTO.mapToDTO(invoiceServiceEntryService.list());}

    @GetMapping
    public InvoiceServiceEntryDTO get(@RequestParam Integer id) {
        return invoiceServiceEntryMapperDTO.map(invoiceServiceEntryService.get(id));
    }
    @PostMapping
    public InvoiceServiceEntryDTO create(@RequestBody InvoiceServiceEntryDTO invoiceServiceEntryDTO){
        InvoiceServiceEntryDomain output = invoiceServiceEntryService.create(
                invoiceServiceEntryMapperDTO.map(invoiceServiceEntryDTO)
        );
        return invoiceServiceEntryMapperDTO.map(output);
    }
    @PutMapping
    public InvoiceServiceEntryDTO update(@RequestBody InvoiceServiceEntryDTO invoiceServiceEntryDTO){
        InvoiceServiceEntryDomain output = invoiceServiceEntryService.update(
                invoiceServiceEntryMapperDTO.map(invoiceServiceEntryDTO)
        );
        return invoiceServiceEntryMapperDTO.map(output);
    }
    @DeleteMapping
    public void delete(@RequestParam Integer id){
        invoiceServiceEntryService.delete(id);
    }

}
