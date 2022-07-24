package pl.edu.wszib.MyFreelancePal.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.MyFreelancePal.model.Settings;
import pl.edu.wszib.MyFreelancePal.repository.SettingsRepository;
import pl.edu.wszib.MyFreelancePal.service.common.CrudService;
import pl.edu.wszib.MyFreelancePal.service.domain.SettingsDomain;
import pl.edu.wszib.MyFreelancePal.service.mapper.SettingsMapper;

import java.util.List;

@Service
public class SettingsService implements CrudService<SettingsDomain, Integer> {

    @Autowired
    private SettingsRepository settingsRepository;
    private SettingsMapper settingsMapper = Mappers.getMapper(SettingsMapper.class);


    @Override
    public List<SettingsDomain> list() {
        return settingsMapper.mapToDomain(settingsRepository.findAll());
    }

    @Override
    public SettingsDomain get(Integer integer) {
        return settingsRepository.findById(integer)
                .map(settings -> settingsMapper.map(settings))
                .orElse(null);
    }

    @Override
    public SettingsDomain create(SettingsDomain settingsDomain) {
        settingsDomain.setId(null);
        Settings created = settingsRepository.save(settingsMapper.map(settingsDomain));
        return settingsMapper.map(created);
    }

    @Override
    public SettingsDomain update(SettingsDomain settingsDomain) {
        SettingsDomain existing = get(settingsDomain.getId());
        if(existing == null){
            return null;
        }
        Settings updated = settingsRepository.save(settingsMapper.map(settingsDomain));
        return settingsMapper.map(updated);
    }

    @Override
    public void delete(Integer integer) {
        settingsRepository.deleteById(integer);

    }
}
