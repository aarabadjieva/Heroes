package app.repository;

import app.domain.entity.Hero;

import java.util.List;

public interface HeroRepository {

    void save(Hero hero);

    List<Hero> findAll();

    Hero findByName(String heroName);

    void delete(Hero hero);
}
