package pl.edu.wszib.MyFreelancePal.controller.web;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.MyFreelancePal.controller.mapper.SettingsMapperDTO;
import pl.edu.wszib.MyFreelancePal.service.SettingsService;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;
    private SettingsMapperDTO settingsMapperDTO = Mappers.getMapper(SettingsMapperDTO.class);


}
