package app.repository;

import app.domain.entity.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User findByNameAndPassword(String username, String password) {
        List<User> users = entityManager.createQuery("select u from User u where u.username=:username " +
                "and u.password=:password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();
        if (users.isEmpty()){
            return null;
        }
        return users.get(0);
    }
}
