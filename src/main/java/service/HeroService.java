package service;

import domain.model.binding.HeroBindingModel;
import domain.model.service.HeroServiceModel;
import domain.model.view.HeroDetailsViewModel;

import java.util.List;

public interface HeroService {
  void save(HeroBindingModel heroBindingModel);
  List<HeroServiceModel> getAll();
  HeroDetailsViewModel getHeroWithId(String id);
  void deleteHero(String id);
}
