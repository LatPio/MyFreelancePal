package pl.edu.wszib.MyFreelancePal.controller.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.controller.dto.SettingsDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.SettingsDomain;

import java.util.List;

@Mapper
public interface SettingsMapperDTO {
    SettingsDTO map(SettingsDomain settingsDomain);
    SettingsDomain map(SettingsDTO settingsDTO);
    List<SettingsDTO> mapToDTO(List<SettingsDomain> settingsDomains);
}
