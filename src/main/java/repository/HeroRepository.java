package repository;

import domain.entitiy.Hero;

import java.util.List;

public interface HeroRepository {
  void save(Hero hero);

  List<Hero> getAll();

  Hero getHeroWithId(String id);

  void deleteHero(String id);
}
