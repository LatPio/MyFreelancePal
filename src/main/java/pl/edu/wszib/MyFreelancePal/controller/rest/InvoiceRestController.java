package pl.edu.wszib.MyFreelancePal.controller.rest;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.InvoiceMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.InvoiceService;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;

import java.util.List;

@RestController
@RequestMapping("/rest/invoice")
public class InvoiceRestController {

    @Autowired
    private InvoiceService invoiceService;
    private InvoiceMapperDTO invoiceMapperDTO = Mappers.getMapper(InvoiceMapperDTO.class);

    @GetMapping("/list")
    public List<InvoiceDTO> list(){
        return invoiceMapperDTO.mapToDTO(invoiceService.list());
    }

    @GetMapping
    public InvoiceDTO get(@RequestParam String id){
        return invoiceMapperDTO.map(invoiceService.get(id));
    }

    @PostMapping
    public  InvoiceDTO create(@RequestBody InvoiceDTO invoiceDTO){
        InvoiceDomain output = invoiceService.create(
                invoiceMapperDTO.map(invoiceDTO)
        );
        return invoiceMapperDTO.map(output);
    }
    @PutMapping
    public InvoiceDTO update(@RequestBody InvoiceDTO invoiceDTO){
        InvoiceDomain output = invoiceService.update(
                invoiceMapperDTO.map(invoiceDTO)
        );
        return invoiceMapperDTO.map(output);
    }
    @DeleteMapping
    public void delete(@RequestParam String id){
        invoiceService.delete(id);
    }
}
