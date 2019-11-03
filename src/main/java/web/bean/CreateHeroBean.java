package web.bean;

import domain.model.binding.HeroBindingModel;
import service.HeroService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CreateHeroBean extends BaseBean {
  private HeroBindingModel heroBindingModel;
  private HeroService heroService;


  @Inject
  public CreateHeroBean(HeroService heroService) {
    this.heroService = heroService;
  }

  @PostConstruct
  private void init() {
    this.heroBindingModel = new HeroBindingModel();
  }


  public HeroBindingModel getHeroBindingModel() {
    return heroBindingModel;
  }

  public void setHeroBindingModel(HeroBindingModel heroBindingModel) {
    this.heroBindingModel = heroBindingModel;
  }

  public void createHero() {
    heroService.save(this.heroBindingModel);
    super.redirect("/home");
  }
}
