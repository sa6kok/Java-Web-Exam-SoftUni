package service.impl;

import domain.entitiy.Hero;
import domain.model.binding.HeroBindingModel;
import domain.model.service.HeroServiceModel;
import domain.model.view.HeroDetailsViewModel;
import org.modelmapper.ModelMapper;
import repository.HeroRepository;
import service.HeroService;

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
  public void save(HeroBindingModel heroBindingModel) {
    heroRepository.save(modelMapper.map(heroBindingModel, Hero.class));
  }

  @Override
  public List<HeroServiceModel> getAll() {
    List<HeroServiceModel> collect = heroRepository.getAll().stream().map(h -> modelMapper.map(h, HeroServiceModel.class)).collect(Collectors.toList());
    System.out.println();
    return collect;
  }

  @Override
  public HeroDetailsViewModel getHeroWithId(String id) {
   return modelMapper.map(heroRepository.getHeroWithId(id), HeroDetailsViewModel.class);
  }

  @Override
  public void deleteHero(String id) {
    heroRepository.deleteHero(id);
  }
}
