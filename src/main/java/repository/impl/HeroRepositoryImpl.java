package repository.impl;

import domain.entitiy.Hero;
import repository.HeroRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class HeroRepositoryImpl implements HeroRepository {
  private final EntityManager entityManager;

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
  public List<Hero> getAll() {
    List<Hero> resultList = entityManager.createQuery("select h from Hero h order by h.level desc ", Hero.class).getResultList();
    return resultList;
  }

  @Override
  public Hero getHeroWithId(String id) {
    return entityManager.createQuery("select h from Hero h where h.id=:id", Hero.class).setParameter("id", id).getSingleResult();
  }

  @Override
  public void deleteHero(String id) {
    entityManager.getTransaction().begin();
    entityManager.createQuery("delete from Hero h where h.id=:id").setParameter("id", id).executeUpdate();
    entityManager.getTransaction().commit();
  }
}
