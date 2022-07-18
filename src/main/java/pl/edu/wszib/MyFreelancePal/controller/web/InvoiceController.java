package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.allegro.finance.tradukisto.MoneyConverters;
import pl.edu.wszib.MyFreelancePal.controller.dto.*;
import pl.edu.wszib.MyFreelancePal.controller.mapper.*;
import pl.edu.wszib.MyFreelancePal.service.*;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private EmployerManagerService employerManagerService;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskInvoiceService taskInvoiceService;

    @Autowired
    private InvoiceServiceEntryService invoiceServiceEntryService;

    private InvoiceMapperDTO invoiceMapperDTO = Mappers.getMapper(InvoiceMapperDTO.class);
    private EmployerManagerMapperDTO employerManagerMapperDTO = Mappers.getMapper(EmployerManagerMapperDTO.class);
    private EmployeeMapperDTO employeeMapperDTO = Mappers.getMapper(EmployeeMapperDTO.class);
    private TaskMapperDTO taskMapperDTO = Mappers.getMapper(TaskMapperDTO.class);
    private InvoiceServiceEntryMapperDTO invoiceServiceEntryMapperDTO = Mappers.getMapper(InvoiceServiceEntryMapperDTO.class);

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("InvoiceList", invoiceMapperDTO.mapToDTO(invoiceService.list()));
        return "invoice/invoiceList";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("newInvoice", new InvoiceDTO());
        List<EmployerManagerDTO> allEmployers = employerManagerMapperDTO.mapToDTO(employerManagerService.list());
        model.addAttribute("ListOfEmployers", allEmployers);
        List<EmployeeDTO> allEmployee = employeeMapperDTO.mapToDTO(employeeService.list());
        model.addAttribute("ListOfEmployees", allEmployee);
        model.addAttribute("today", LocalDate.now() );

        return "invoice/invoiceCreate";
    }
    @PostMapping("/create")
    public String createAction(Model model, InvoiceDTO invoiceDTO){
        invoiceDTO.setSecondDate(invoiceDTO.getInvoiceCreationDate());
        LocalDate datePlus14days = invoiceDTO.getInvoiceCreationDate().toLocalDate().plusDays(14);
        invoiceDTO.setPayDue(Date.valueOf(datePlus14days));
        invoiceDTO.setDaysToPay(14);
        invoiceDTO.setVat(23);
        invoiceDTO.setAmountNet(BigDecimal.valueOf(0));
        invoiceDTO.setAmountVat(BigDecimal.valueOf(0));
        invoiceDTO.setAmountPreTax(BigDecimal.valueOf(0));
        InvoiceDomain invoiceDomain = invoiceService.create(invoiceMapperDTO.map(invoiceDTO));
        return "redirect:/invoice/list";
    }


    @GetMapping("/get")
    public String get(Model model, @RequestParam Integer id){
        model.addAttribute("getInvoice", invoiceMapperDTO.map(invoiceService.get(id)));
        model.addAttribute("listOfInvoiceEntries", invoiceServiceEntryMapperDTO.mapToDTO(invoiceServiceEntryService.listByInvoice(id)));
        return "invoice/invoiceGet";
    }



    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model){
        model.addAttribute("updateInvoice", invoiceMapperDTO.map(invoiceService.get(id)));
        model.addAttribute("listOfInvoiceEntries", invoiceServiceEntryMapperDTO.mapToDTO(invoiceServiceEntryService.listByInvoice(id)));
        return "invoice/invoiceUpdate";
    }

    @PostMapping("/update")
    public String updateAction(InvoiceDTO invoiceDTO, Model model, @RequestParam Integer id){
        List<InvoiceServiceEntryDTO> listOfInvoiceEntries = invoiceServiceEntryMapperDTO.mapToDTO(invoiceServiceEntryService.listByInvoice(id));
//        invoiceDTO.setVat(23);
        List<BigDecimal> amountNet = new ArrayList<>();
        List<BigDecimal> amountVat = new ArrayList<>();
        List<BigDecimal> amountPreTax = new ArrayList<>();
        if (listOfInvoiceEntries.isEmpty()) {
            amountNet.add(0, BigDecimal.valueOf(0));
        } else {
            listOfInvoiceEntries.forEach(invoiceServiceEntryDTO -> amountNet.add(invoiceServiceEntryDTO.getNetAmount()));
            listOfInvoiceEntries.forEach(invoiceServiceEntryDTO -> amountPreTax.add(invoiceServiceEntryDTO.getPreTaxAmount()));
            listOfInvoiceEntries.forEach(invoiceServiceEntryDTO -> amountVat.add(invoiceServiceEntryDTO.getVatAmount()));
        }
        invoiceDTO.setAmountNet(amountNet.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
        invoiceDTO.setAmountVat(amountVat.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
        invoiceDTO.setAmountPreTax(amountPreTax.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
        MoneyConverters converters = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
        converters.asWords(invoiceDTO.getAmountPreTax(), "PLN");
        invoiceDTO.setAmountInWords(converters.asWords(invoiceDTO.getAmountPreTax(), "PLN"));

        Integer days = Math.toIntExact(ChronoUnit.DAYS.between(invoiceDTO.getInvoiceCreationDate().toLocalDate(), invoiceDTO.getPayDue().toLocalDate() ));
        invoiceDTO.setDaysToPay(days);
        InvoiceDomain invoiceDomain = invoiceService.update(invoiceMapperDTO.map(invoiceDTO));
        return "redirect:/invoice/get?id=" + id;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, Model model){
        model.addAttribute("deleteInvoice", invoiceService.get(id));
        return "invoice/invoiceDelete";
    }

    @PostMapping("/delete")
    public String deleteAction (InvoiceDTO invoiceDTO, Model model){

        invoiceService.delete(invoiceDTO.getId());
        return "redirect:/invoice/list";
    }

}
