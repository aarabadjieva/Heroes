package app.web.beans.user;

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
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Named
@RequestScoped
public class HomeBean extends BaseBean {

    private List<HeroViewModel> heroes;
    private HeroService heroService;
    private ModelMapper modelMapper;

    @Inject
    public HomeBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init(){
        heroes = heroService.findAll().stream()
                .map(h->modelMapper.map(h, HeroViewModel.class))
                .collect(Collectors.toList());
        getHeroes().forEach(h->h.setClazz(h.getClazz().toLowerCase()));
    }

    public List<HeroViewModel> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<HeroViewModel> heroes) {
        this.heroes = heroes;
    }

    public void deleteHero(String heroName){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().replace("heroName", heroName);
        redirect("/heroes/delete?name="+heroName);
    }
}
