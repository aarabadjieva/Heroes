package app.service;

import app.domain.model.service.HeroServiceModel;

import java.util.List;

public interface HeroService {

    void createHero(HeroServiceModel hero);

    List<HeroServiceModel> findAll();

    HeroServiceModel findByName(String heroName);

    void removeHero(HeroServiceModel heroServiceModel);
}
