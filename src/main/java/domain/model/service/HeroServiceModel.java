package domain.model.service;

public class HeroServiceModel {
  private String id;
  private String name;
  private String clazz;

  public HeroServiceModel() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getClazz() {
    return clazz.toLowerCase();
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }
}
