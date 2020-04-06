package app.web.beans.hero;

import app.domain.model.view.HeroViewModel;
import app.service.HeroService;
import app.web.beans.BaseBean;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@NoArgsConstructor
@Named
@RequestScoped
public class HeroDetailsBean extends BaseBean {

    private HeroViewModel hero;
    private HeroService heroService;
    private ModelMapper modelMapper;

    @Inject
    public HeroDetailsBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init(){
        String heroName = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest())
                .getParameter("name");
        hero = modelMapper.map(heroService.findByName(heroName), HeroViewModel.class);
        System.out.println();
    }

    public HeroViewModel getHero() {
        return hero;
    }

    public void setHero(HeroViewModel hero) {
        this.hero = hero;
    }

}
