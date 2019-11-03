package web.bean;

import domain.model.service.HeroServiceModel;
import service.HeroService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class HomeBean extends BaseBean {
  private HeroServiceModel heroServiceModel;
  private HeroService heroService;

  public HomeBean() {
  }

  @Inject
  public HomeBean(HeroService heroService) {
    this.heroService = heroService;
  }

  @PostConstruct
  private void init() {
    this.heroServiceModel = new HeroServiceModel();
  }

  public HeroServiceModel getHeroServiceModel() {
    return heroServiceModel;
  }

  public void setHeroServiceModel(HeroServiceModel heroServiceModel) {
    this.heroServiceModel = heroServiceModel;
  }

  public List<HeroServiceModel> getAllHeroes() {
   return heroService.getAll();
  }
}
