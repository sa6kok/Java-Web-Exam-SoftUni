package web.bean;

import domain.model.view.HeroDetailsViewModel;
import service.HeroService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
public class DetailsHeroBean {
  private String id;
  private HeroDetailsViewModel hero;
  private HeroService heroService;

  public DetailsHeroBean() {
  }

  @Inject
  public DetailsHeroBean(HeroService heroService) {
    this.heroService = heroService;
  }

  @PostConstruct
  private void init() {
    this.setId(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("heroId"));

  setHero(getHeroWithId());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public HeroDetailsViewModel getHero() {
    return hero;
  }

  public void setHero(HeroDetailsViewModel hero) {
    this.hero = hero;
  }

  public HeroDetailsViewModel getHeroWithId() {
    HeroDetailsViewModel heroDetailsViewModel = heroService.getHeroWithId(this.id);
    System.out.println();
    return heroDetailsViewModel;
  }
}
