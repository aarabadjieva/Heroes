package app.service;

import app.domain.entity.Hero;
import app.domain.model.service.HeroServiceModel;
import app.repository.HeroRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;

    @Inject
    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createHero(HeroServiceModel hero) {
        heroRepository.save(modelMapper.map(hero, Hero.class));
    }

    @Override
    public List<HeroServiceModel> findAll() {
        return heroRepository.findAll().stream()
                .map(h->modelMapper.map(h, HeroServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public HeroServiceModel findByName(String heroName) {
        return modelMapper.map(heroRepository.findByName(heroName), HeroServiceModel.class);
    }

    @Override
    public void removeHero(HeroServiceModel heroServiceModel) {
        heroRepository.delete(modelMapper.map(heroServiceModel, Hero.class));
    }
}
