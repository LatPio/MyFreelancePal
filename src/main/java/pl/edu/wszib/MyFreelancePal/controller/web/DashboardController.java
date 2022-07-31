package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.MyFreelancePal.controller.dto.ProjectManagerDTO;
import pl.edu.wszib.MyFreelancePal.controller.mapper.*;
import pl.edu.wszib.MyFreelancePal.service.*;
import pl.edu.wszib.MyFreelancePal.service.domain.ProjectManagerDomain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Controller
@RequestMapping
public class DashboardController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectManagerService projectManagerService;
    @Autowired
    private EmployerManagerService employerManagerService;
    @Autowired
    private InvoiceService invoiceService;


    private TaskMapperDTO taskMapperDTO = Mappers.getMapper(TaskMapperDTO.class);
    private ProjectManagerMapperDTO projectManagerMapperDTO = Mappers.getMapper(ProjectManagerMapperDTO.class);
    private EmployerManagerMapperDTO employerManagerMapperDTO = Mappers.getMapper(EmployerManagerMapperDTO.class);

    @GetMapping
    public String defaultView(){
        return "redirect:/";
    }

    @GetMapping("/")
    public String view(Model model){
        model.addAttribute("countActiveProject", projectManagerService.countActiveProject(true));
        model.addAttribute("allProjectCount", projectManagerService.countProject());

        model.addAttribute("countPendingTasks", taskService.countPendingTasks(false));
        model.addAttribute("allTaskCount", taskService.countTask());
        model.addAttribute("sumTime", taskService.totalMinutes());
        model.addAttribute("countInvoices", invoiceService.countInvoices());
        model.addAttribute("notCashedTasks", taskService.countByInvoiceCreatedFalse());
        model.addAttribute("activeEmployers", employerManagerMapperDTO.mapToDTO(employerManagerService.findByActive(true)));
        model.addAttribute("projectByActiveEmployer", projectManagerMapperDTO.mapToDTO(projectManagerService.findByEmployer_Active(true)));
        BigDecimal monthEarnings = BigDecimal.valueOf(0);
        if(taskService.sumAmountByInvoiceCreated(LocalDateTime.now().withDayOfMonth(1), LocalDateTime.now().withDayOfMonth(31)) != null){
            monthEarnings = monthEarnings.add(taskService.sumAmountByInvoiceCreated(LocalDateTime.now().withDayOfMonth(1), LocalDateTime.now().withDayOfMonth(31)).setScale(2, RoundingMode.HALF_UP));
        }
        model.addAttribute("sumAmount", monthEarnings);

        List<String> labels = new ArrayList<>();
        Stream.iterate(12, n -> n-1).limit(13).forEach(integer -> labels.add(LocalDateTime.now().minusMonths(integer).format(DateTimeFormatter.ofPattern("yyyy - MM"))) );
        model.addAttribute("labels", labels);

        List<BigDecimal> monthlyEarnings = new ArrayList<>();
        Stream.iterate(12, n -> n-1).limit(13).forEach(integer -> {
            if(taskService.sumAmountByInvoiceCreated(LocalDateTime.now().withDayOfMonth(1).minusMonths(integer), LocalDateTime.now().withDayOfMonth(31).minusMonths(integer)) == null){
            monthlyEarnings.add(BigDecimal.valueOf(0));
            } else {
            monthlyEarnings.add(taskService.sumAmountByInvoiceCreated(LocalDateTime.now().withDayOfMonth(1).minusMonths(integer), LocalDateTime.now().withDayOfMonth(31).minusMonths(integer)).setScale(2, RoundingMode.HALF_UP));
            }
        });
        model.addAttribute("dataSetMonthlyEarnings", monthlyEarnings);

        List<Long> monthlySpendTime = new ArrayList<>();
        Stream.iterate(12, n -> n-1).limit(13).forEach(integer -> {
            if(taskService.sumTimeByInvoiceCreated(LocalDateTime.now().withDayOfMonth(1).minusMonths(integer), LocalDateTime.now().withDayOfMonth(31).minusMonths(integer)) == null){
                monthlySpendTime.add(0l);
            } else {
                monthlySpendTime.add(taskService.sumTimeByInvoiceCreated(LocalDateTime.now().withDayOfMonth(1).minusMonths(integer), LocalDateTime.now().withDayOfMonth(31).minusMonths(integer)));
            }
        });

        model.addAttribute("dataSetMonthlySpendTime", monthlySpendTime);
        return "dashboard/dashboardView";
    }

    @GetMapping("/updateActiveTrue")
    public String updateActiveTrue(@RequestParam Integer id){
        ProjectManagerDTO projectManagerDTO = projectManagerMapperDTO.map(projectManagerService.get(id));
        projectManagerDTO.setActiveProject(true);
        ProjectManagerDomain projectManagerDomain=projectManagerService.update(projectManagerMapperDTO.map(projectManagerDTO));
        return "redirect:/";
    }

    @GetMapping("/updateActiveFalse")
    public String updateActiveFalse(@RequestParam Integer id){
        ProjectManagerDTO projectManagerDTO = projectManagerMapperDTO.map(projectManagerService.get(id));
        projectManagerDTO.setActiveProject(false);
        ProjectManagerDomain projectManagerDomain=projectManagerService.update(projectManagerMapperDTO.map(projectManagerDTO));
        return "redirect:/";
    }
}
