package pl.edu.wszib.MyFreelancePal.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.edu.wszib.MyFreelancePal.model.Settings;
import pl.edu.wszib.MyFreelancePal.service.domain.SettingsDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-26T12:24:05+0200",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class SettingsMapperImpl implements SettingsMapper {

    @Override
    public SettingsDomain map(Settings settings) {
        if ( settings == null ) {
            return null;
        }

        SettingsDomain.SettingsDomainBuilder settingsDomain = SettingsDomain.builder();

        settingsDomain.id( settings.getId() );
        settingsDomain.vat( settings.getVat() );
        settingsDomain.defaultHourPrice( settings.getDefaultHourPrice() );
        settingsDomain.globalCurrency( settings.getGlobalCurrency() );

        return settingsDomain.build();
    }

    @Override
    public Settings map(SettingsDomain settingsDomain) {
        if ( settingsDomain == null ) {
            return null;
        }

        Settings.SettingsBuilder settings = Settings.builder();

        settings.id( settingsDomain.getId() );
        settings.vat( settingsDomain.getVat() );
        settings.defaultHourPrice( settingsDomain.getDefaultHourPrice() );
        settings.globalCurrency( settingsDomain.getGlobalCurrency() );

        return settings.build();
    }

    @Override
    public List<SettingsDomain> mapToDomain(List<Settings> settings) {
        if ( settings == null ) {
            return null;
        }

        List<SettingsDomain> list = new ArrayList<SettingsDomain>( settings.size() );
        for ( Settings settings1 : settings ) {
            list.add( map( settings1 ) );
        }

        return list;
    }
}
