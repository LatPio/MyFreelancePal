package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceServiceEntryDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskInvoiceDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.InvoiceServiceEntryMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.ProjectManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.TaskInvoiceMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.TaskMapperDTO;
import pl.edu.wszib.MyFreelancePal.model.Task;
import pl.edu.wszib.MyFreelancePal.service.InvoiceServiceEntryService;
import pl.edu.wszib.MyFreelancePal.service.ProjectManagerService;
import pl.edu.wszib.MyFreelancePal.service.TaskInvoiceService;
import pl.edu.wszib.MyFreelancePal.service.TaskService;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceServiceEntryDomain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDateTime;
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
    private ProjectManagerService projectManagerService;
    @Autowired
    private TaskInvoiceService taskInvoiceService;

    private TaskInvoiceMapperDTO taskInvoiceMapperDTO = Mappers.getMapper(TaskInvoiceMapperDTO.class);
    private InvoiceServiceEntryMapperDTO invoiceServiceEntryMapperDTO = Mappers.getMapper(InvoiceServiceEntryMapperDTO.class);
    private ProjectManagerMapperDTO projectManagerMapperDTO = Mappers.getMapper(ProjectManagerMapperDTO.class);

    @GetMapping("/create")
    public String create(Model model, @RequestParam Integer idOfEmployer, @RequestParam Integer idOfInvoice){
        model.addAttribute("newInvoiceEntry", new InvoiceServiceEntryDTO());
        model.addAttribute("listOfProjectWithTasks", projectManagerMapperDTO.mapToDTO(projectManagerService.list2(idOfEmployer)));
        model.addAttribute("idOfInvoice", idOfInvoice);
        return "invoiceServiceEntry/invoiceServiceEntryCreate";
    }


    @PostMapping("create")
    public String createAction(Model model, InvoiceServiceEntryDTO invoiceServiceEntryDTO, @RequestParam Integer idOfInvoice){

        List<TaskInvoiceDTO> tasks = new ArrayList<>();
        List<Integer> listOfIds = Arrays.asList(invoiceServiceEntryDTO.getIdsOfTasks().split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());

        listOfIds.forEach(integer -> tasks.add(taskInvoiceMapperDTO.map(taskInvoiceService.get(integer))));

        tasks.forEach(taskInvoiceDTO -> taskInvoiceDTO.setInvoiceCreated(true));
        tasks.forEach(taskInvoiceDTO -> taskInvoiceDTO.setTimeOfInvoiceCreation(Instant.now()));




        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------v");

        List<Long> time = new ArrayList<>();
        tasks.forEach(taskInvoiceDTO -> time.add(taskInvoiceDTO.getTimeOfWorkInMin().longValue()));
        Long sum = time.stream().mapToLong(value -> value).sum();
        System.out.println(sum);
        invoiceServiceEntryDTO.setAmount(sum.intValue());
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------v");
        List<BigDecimal> eachNetAmount =new ArrayList<>();
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
        toUpdate.setNetAmount(sumResult);
        toUpdate.setNetPrice(sumResult.divide(BigDecimal.valueOf(sum)));
        toUpdate.setPreTaxAmount(sumResult.multiply(new BigDecimal(1.23)));
        toUpdate.setVatAmount(sumResult.multiply(new BigDecimal(0.23)));
        toUpdate.setVat(23);

        InvoiceServiceEntryDomain invoiceServiceEntryDomainToReUpdate = invoiceServiceEntryService.update(invoiceServiceEntryMapperDTO.map(toUpdate));
//        InvoiceServiceEntryDomain update = invoiceServiceEntryService.update(invoiceServiceEntryMapperDTO.map());
        return "redirect:/invoice/update?id=" + idOfInvoice;
    }


}
