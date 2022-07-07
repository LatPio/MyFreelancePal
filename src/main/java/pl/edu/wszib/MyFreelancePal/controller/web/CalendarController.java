package pl.edu.wszib.MyFreelancePal.controller.web;


import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @SneakyThrows
    @GetMapping
    public String callView(Model model) {
        return "calendar/calendarView";
    }

}
