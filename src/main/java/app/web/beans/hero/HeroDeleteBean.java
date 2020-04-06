package app.web.beans.hero;

import app.service.HeroService;
import app.web.beans.BaseBean;
import lombok.NoArgsConstructor;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@NoArgsConstructor
@Named
@RequestScoped
public class HeroDeleteBean extends BaseBean {

    private HeroService heroService;

    @Inject
    public HeroDeleteBean(HeroService heroService) {
        this.heroService = heroService;
    }

    public void delete(){
        String name = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("heroName");
        heroService.removeHero(heroService.findByName(name));
        redirect("/home");
    }
}
