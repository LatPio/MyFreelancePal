package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.MyFreelancePal.controller.dto.*;
import pl.edu.wszib.MyFreelancePal.controller.mapper.*;
import pl.edu.wszib.MyFreelancePal.service.*;
import pl.edu.wszib.MyFreelancePal.service.domain.InvoiceDomain;

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
    private TaskService taskService;

    private InvoiceMapperDTO invoiceMapperDTO = Mappers.getMapper(InvoiceMapperDTO.class);
    private EmployerManagerMapperDTO employerManagerMapperDTO = Mappers.getMapper(EmployerManagerMapperDTO.class);
    private EmployeeMapperDTO employeeMapperDTO = Mappers.getMapper(EmployeeMapperDTO.class);
    private TaskMapperDTO taskMapperDTO = Mappers.getMapper(TaskMapperDTO.class);

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

        return "invoice/invoiceCreate";
    }
    @PostMapping("/create")
    public String createAction(Model model, InvoiceDTO invoiceDTO){
        InvoiceDomain invoiceDomain = invoiceService.create(invoiceMapperDTO.map(invoiceDTO));
        return "redirect:/invoice/list";
    }


    @GetMapping("/get")
    public String get(Model model, @RequestParam Integer id){
        model.addAttribute("getInvoice", invoiceMapperDTO.map(invoiceService.get(id)));
        return "invoice/invoiceGet";
    }



    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model){
        model.addAttribute("updateInvoice", invoiceMapperDTO.map(invoiceService.get(id)));

        return "invoice/invoiceUpdate";
    }

    @PostMapping("/update")
    public String updateAction(InvoiceDTO invoiceDTO, Model model, @RequestParam Integer id){
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
