package app.web.beans;

import app.domain.entity.Clazz;
import app.domain.entity.Country;
import lombok.NoArgsConstructor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@NoArgsConstructor
@Named
@RequestScoped
public class EnumBean {

    public Country[] countryNames(){
        return Country.values();
    }

    public Clazz[] clazzes(){
        return Clazz.values();
    }

}
