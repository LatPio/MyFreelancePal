package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceServiceEntryDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskInvoiceDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.*;
import pl.edu.wszib.MyFreelancePal.service.*;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceServiceEntryDomain;

import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/invoice-entry")
public class InvoiceServiceEntryController {
    @Autowired
    private InvoiceServiceEntryService invoiceServiceEntryService;
    @Autowired
    private TaskInvoiceService taskInvoiceService;

    @Autowired
    private EmployeeManagerService employeeManagerService;

    @Autowired
    private InvoiceService invoiceService;

    private InvoiceMapperDTO invoiceMapperDTO = Mappers.getMapper(InvoiceMapperDTO.class);

    private EmployeeManagerMapperDTO employeeManagerMapperDTO = Mappers.getMapper(EmployeeManagerMapperDTO.class);
    private TaskInvoiceMapperDTO taskInvoiceMapperDTO = Mappers.getMapper(TaskInvoiceMapperDTO.class);
    private InvoiceServiceEntryMapperDTO invoiceServiceEntryMapperDTO = Mappers.getMapper(InvoiceServiceEntryMapperDTO.class);

    @GetMapping("/create")
    public String create(Model model, @RequestParam Integer idOfEmployer, @RequestParam String idOfInvoice){
        model.addAttribute("newInvoiceEntry", new InvoiceServiceEntryDTO());
        model.addAttribute("listOfTasks",  taskInvoiceMapperDTO.mapToDTO(taskInvoiceService.findTaskTestingForGrandparent(idOfEmployer, true, false)));
        model.addAttribute("idOfInvoice", idOfInvoice);
        model.addAttribute("idOfEmployer", idOfEmployer);
        return "invoiceServiceEntry/invoiceServiceEntryCreate";
    }

    @PostMapping("create")
    public String createAction(@Valid InvoiceServiceEntryDTO invoiceServiceEntryDTO, BindingResult bindingResult, Model model, @RequestParam String idOfInvoice, @RequestParam Integer idOfEmployer) throws IOException {
        if(bindingResult.hasErrors()){
            model.addAttribute("org.springframework.validation.BindingResult.newInvoiceEntry", bindingResult);
            model.addAttribute("listOfTasks",  taskInvoiceMapperDTO.mapToDTO(taskInvoiceService.findTaskTestingForGrandparent(idOfEmployer, true, false)));
            model.addAttribute("idOfInvoice", idOfInvoice);
            model.addAttribute("idOfEmployer", idOfEmployer);
            model.addAttribute("newInvoiceEntry", invoiceServiceEntryDTO);
            return "invoiceServiceEntry/invoiceServiceEntryCreate";
        }

        List<TaskInvoiceDTO> tasks = new ArrayList<>();
        List<Integer> listOfIds = Arrays.asList(invoiceServiceEntryDTO.getIdsOfTasks().split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        listOfIds.forEach(integer -> tasks.add(taskInvoiceMapperDTO.map(taskInvoiceService.get(integer))));

        tasks.forEach(taskInvoiceDTO -> taskInvoiceDTO.setInvoiceCreated(true));
        tasks.forEach(taskInvoiceDTO -> taskInvoiceDTO.setTimeOfInvoiceCreation(Instant.now()));

        List<Long> time = new ArrayList<>();
        tasks.forEach(taskInvoiceDTO -> time.add(taskInvoiceDTO.getTimeOfWorkInMin().longValue()));
        Long sum = time.stream().mapToLong(value -> value).sum();
        invoiceServiceEntryDTO.setAmount(sum.intValue());
        List<BigDecimal> eachNetAmount =  new ArrayList<>();

        tasks.forEach(taskInvoiceDTO -> {
            BigDecimal a = taskInvoiceDTO.getHourPrice();
            BigDecimal b = BigDecimal.valueOf(taskInvoiceDTO.getTimeOfWorkInMin().longValue());
            BigDecimal aa = a.divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP);
            BigDecimal c = aa.multiply(b);
            eachNetAmount.add(c);
        } );
        BigDecimal sumResult = eachNetAmount.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        InvoiceServiceEntryDomain invoiceServiceEntryDomain = invoiceServiceEntryService.create(invoiceServiceEntryMapperDTO.map(invoiceServiceEntryDTO));
        tasks.forEach(taskDTO -> taskDTO.setInvoiceServiceEntry(invoiceServiceEntryMapperDTO.map(invoiceServiceEntryDomain)));
        tasks.forEach(taskDTO -> taskInvoiceService.update(taskInvoiceMapperDTO.map(taskDTO)));
        InvoiceServiceEntryDTO toUpdate = invoiceServiceEntryMapperDTO.map(invoiceServiceEntryService.get(invoiceServiceEntryDomain.getId()));
        toUpdate.setUnit("min");
        toUpdate.setNetPrice(sumResult.divide(BigDecimal.valueOf(sum), 2 , RoundingMode.HALF_UP));
        Integer vat = invoiceService.get(idOfInvoice).getEmployee().getVat();
        toUpdate.setVat(vat);
        toUpdate.setNetAmount( toUpdate.getNetPrice().multiply(BigDecimal.valueOf(toUpdate.getAmount())) );

        if(vat == 0){
            toUpdate.setVatAmount(sumResult);
        }else {
            toUpdate.setVatAmount(sumResult.multiply(new BigDecimal(vat.doubleValue()/100)));
        }
        toUpdate.setPreTaxAmount(sumResult.multiply(new BigDecimal(1 + vat)));

        InvoiceServiceEntryDomain invoiceServiceEntryDomainToReUpdate = invoiceServiceEntryService.update(invoiceServiceEntryMapperDTO.map(toUpdate));
        return "redirect:/invoice/update?id=" + idOfInvoice;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model, @RequestParam String idOfInvoice){
        model.addAttribute("idOfInvoice", idOfInvoice);
        model.addAttribute("deleteInvoiceEntry", invoiceServiceEntryService.get(id));
        return "invoiceServiceEntry/invoiceServiceEntryDelete";

    }

    @PostMapping("/delete")
    public String deleteAction (InvoiceServiceEntryDTO invoiceServiceEntryDTO, Model model, @RequestParam String idOfInvoice){
        invoiceServiceEntryService.delete(invoiceServiceEntryDTO.getId());
        return "redirect:/invoice/update?id=" + idOfInvoice;
    }

}
