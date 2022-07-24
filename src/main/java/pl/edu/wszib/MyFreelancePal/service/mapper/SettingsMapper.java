package pl.edu.wszib.MyFreelancePal.service.mapper;

import org.mapstruct.Mapper;
import pl.edu.wszib.MyFreelancePal.model.Settings;
import pl.edu.wszib.MyFreelancePal.service.domain.SettingsDomain;

import java.util.List;

@Mapper
public interface SettingsMapper {
    SettingsDomain map(Settings settings);
    Settings map(SettingsDomain settingsDomain);
    List<SettingsDomain> mapToDomain(List<Settings> settings);
}
