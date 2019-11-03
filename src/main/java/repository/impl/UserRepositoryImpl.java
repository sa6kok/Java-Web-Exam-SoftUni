package repository.impl;

import domain.entitiy.User;
import repository.UserRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UserRepositoryImpl implements UserRepository {
  private final   EntityManager entityManager;

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
  public User getUserWithUsernameAndPassword(String username, String password) {
    entityManager.getTransaction().begin();
    User user = entityManager.createQuery("select u from User u where u.username=:username and u.password=:password", User.class).setParameter("username", username)
        .setParameter("password", password).getSingleResult();
    entityManager.getTransaction().commit();
    return user;
  }

  @Override
  public User getUserWithUsername(String username) {
    User user = entityManager.createQuery("select u from User u where u.username=:username", User.class)
        .setParameter("username", username)
        .getSingleResult();
    return user;
  }
}
