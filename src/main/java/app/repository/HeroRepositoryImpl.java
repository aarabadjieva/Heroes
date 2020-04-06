package app.repository;

import app.domain.entity.Hero;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class HeroRepositoryImpl implements HeroRepository {

    private final EntityManager  entityManager;

    @Inject
    public HeroRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Hero hero) {
        entityManager.getTransaction().begin();
        entityManager.persist(hero);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Hero> findAll() {
        return entityManager.createQuery("select h from Hero h order by h.level desc", Hero.class).getResultList();
    }

    @Override
    public Hero findByName(String heroName) {
        return entityManager.createQuery("select h from Hero h where h.name=:heroName", Hero.class)
                .setParameter("heroName", heroName)
                .getSingleResult();
    }

    @Override
    public void delete(Hero hero) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(hero)?hero:entityManager.merge(hero));
        entityManager.getTransaction().commit();
    }
}
