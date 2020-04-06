package app.web.beans.hero;

import app.domain.model.binding.HeroCreateBinding;
import app.domain.model.service.HeroServiceModel;
import app.service.HeroService;
import app.web.beans.BaseBean;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@NoArgsConstructor
@Named
@RequestScoped
public class AddHeroBean extends BaseBean {

    private HeroService heroService;
    private ModelMapper modelMapper;
    private HeroCreateBinding hero;

    @Inject
    public AddHeroBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init(){
        hero = new HeroCreateBinding();
    }

    public HeroCreateBinding getHero() {
        return hero;
    }

    public void setHero(HeroCreateBinding hero) {
        this.hero = hero;
    }

    public void create(){
        HeroServiceModel heroServiceModel = modelMapper.map(hero, HeroServiceModel.class);
        try {
            heroService.createHero(heroServiceModel);
            redirect("/home");
        }catch (Exception e){
            return;
        }
    }
}
