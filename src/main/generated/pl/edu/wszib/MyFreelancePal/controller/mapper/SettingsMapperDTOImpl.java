package pl.edu.wszib.MyFreelancePal.controller.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.controller.dto.SettingsDTO;
import pl.edu.wszib.MyFreelancePal.service.domain.SettingsDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-27T19:47:33+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class SettingsMapperDTOImpl implements SettingsMapperDTO {

    @Override
    public SettingsDTO map(SettingsDomain settingsDomain) {
        if ( settingsDomain == null ) {
            return null;
        }

        SettingsDTO.SettingsDTOBuilder settingsDTO = SettingsDTO.builder();

        settingsDTO.id( settingsDomain.getId() );
        settingsDTO.vat( settingsDomain.getVat() );
        settingsDTO.defaultHourPrice( settingsDomain.getDefaultHourPrice() );
        settingsDTO.globalCurrency( settingsDomain.getGlobalCurrency() );

        return settingsDTO.build();
    }

    @Override
    public SettingsDomain map(SettingsDTO settingsDTO) {
        if ( settingsDTO == null ) {
            return null;
        }

        SettingsDomain.SettingsDomainBuilder settingsDomain = SettingsDomain.builder();

        settingsDomain.id( settingsDTO.getId() );
        settingsDomain.vat( settingsDTO.getVat() );
        settingsDomain.defaultHourPrice( settingsDTO.getDefaultHourPrice() );
        settingsDomain.globalCurrency( settingsDTO.getGlobalCurrency() );

        return settingsDomain.build();
    }

    @Override
    public List<SettingsDTO> mapToDTO(List<SettingsDomain> settingsDomains) {
        if ( settingsDomains == null ) {
            return null;
        }

        List<SettingsDTO> list = new ArrayList<SettingsDTO>( settingsDomains.size() );
        for ( SettingsDomain settingsDomain : settingsDomains ) {
            list.add( map( settingsDomain ) );
        }

        return list;
    }
}
