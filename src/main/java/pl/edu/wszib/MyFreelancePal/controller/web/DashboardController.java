package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.MyFreelancePal.controller.mapper.*;
import pl.edu.wszib.MyFreelancePal.service.EmployerService;
import pl.edu.wszib.MyFreelancePal.service.ProjectManagerService;
import pl.edu.wszib.MyFreelancePal.service.ProjectService;
import pl.edu.wszib.MyFreelancePal.service.TaskService;
import pl.edu.wszib.MyFreelancePal.util.Utilities;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProjectManagerService projectManagerService;
    @Autowired
    private EmployerService employerService;
    @Autowired
    private Utilities utils;
    private TaskMapperDTO taskMapperDTO = Mappers.getMapper(TaskMapperDTO.class);
    private ProjectManagerMapperDTO projectManagerMapperDTO = Mappers.getMapper(ProjectManagerMapperDTO.class);
    private EmployerManagerMapperDTO employerManagerMapperDTO = Mappers.getMapper(EmployerManagerMapperDTO.class);

    @GetMapping
    public String deflautView(){
        return "redirect:dashboard/";
    }

    @GetMapping("/")
    public String view(Model model){
        model.addAttribute("countActiveProject", projectManagerService.countActiveProject(true));
        model.addAttribute("allProjectCount", projectManagerService.countProject());

        model.addAttribute("countPendingTasks", taskService.countPendingTasks(false));
        model.addAttribute("allTaskCount", taskService.countTask());
        model.addAttribute("sumTime", taskService.totalMinutes());


        return "dashboard/dashboardView";
    }
}
