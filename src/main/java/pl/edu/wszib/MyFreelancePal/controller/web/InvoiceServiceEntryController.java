package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.MyFreelancePal.controller.dto.InvoiceServiceEntryDTO;
import pl.edu.wszib.MyFreelancePal.controller.dto.TaskDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.InvoiceServiceEntryMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.ProjectManagerMapperDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.TaskMapperDTO;
import pl.edu.wszib.MyFreelancePal.model.Task;
import pl.edu.wszib.MyFreelancePal.service.InvoiceServiceEntryService;
import pl.edu.wszib.MyFreelancePal.service.ProjectManagerService;
import pl.edu.wszib.MyFreelancePal.service.TaskService;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceServiceEntryDomain;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/invoice-entry")
public class InvoiceServiceEntryController {
    @Autowired
    private InvoiceServiceEntryService invoiceServiceEntryService;

    @Autowired
    private ProjectManagerService projectManagerService;

    @Autowired
    private TaskService taskService;

    private TaskMapperDTO taskMapperDTO = Mappers.getMapper(TaskMapperDTO.class);



    private InvoiceServiceEntryMapperDTO invoiceServiceEntryMapperDTO = Mappers.getMapper(InvoiceServiceEntryMapperDTO.class);
    private ProjectManagerMapperDTO projectManagerMapperDTO = Mappers.getMapper(ProjectManagerMapperDTO.class);

    @GetMapping("/create")
    public String create(Model model, @RequestParam Integer idOfEmployer, @RequestParam Integer idOfInvoice){
        model.addAttribute("newInvoiceEntry", new InvoiceServiceEntryDTO());
        model.addAttribute("listOfProjectWithTasks", projectManagerMapperDTO.mapToDTO(projectManagerService.list2(idOfEmployer)));
        model.addAttribute("listTest", taskMapperDTO.mapToDTO(taskService.list2(idOfEmployer)));
        model.addAttribute("idOfInvoice", idOfInvoice);


        return "invoiceServiceEntry/invoiceServiceEntryCreate";
    }


    @PostMapping("create")
    public String createAction(Model model, InvoiceServiceEntryDTO invoiceServiceEntryDTO, @RequestParam Integer idOfInvoice){
        invoiceServiceEntryDTO.getTasks();
        System.out.println("----------------");
        System.out.println(invoiceServiceEntryDTO.getTasks());
        System.out.println("----------------");
//        invoiceServiceEntryDTO.setName("asdfasdfasdfasdfasdfas afsdf");

//        List<Integer> ids = new ArrayList<>();
//        ids.add(100);
//        ids.add(200);
//        ids.add(300);
//        List<TaskDTO> tasks = listOfTask;
//        List<TaskDTO> tasks = taskMapperDTO.mapToDTO(taskService.list2(200));
//        invoiceServiceEntryDTO.setTasks(tasks);
//        List<TaskDTO> tasks2 = new ArrayList<>();
//        ids.forEach(integer -> tasks2.add(taskMapperDTO.map(taskService.get(integer))));
//        tasks.forEach(taskDTO -> taskDTO.setInvoiceCreated(true));
//        tasks.forEach(taskDTO -> taskService.update(taskMapperDTO.map(taskDTO)));


        InvoiceServiceEntryDomain invoiceServiceEntryDomain = invoiceServiceEntryService.create(invoiceServiceEntryMapperDTO.map(invoiceServiceEntryDTO));

        return "redirect:/invoice/update?id=" + idOfInvoice;
    }


}
