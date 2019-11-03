package domain.entitiy;

import domain.enums.Class;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {
  private String name;
  private Class clazz;
  private int level;

  public Hero() {
  }

  @Column(name = "name", nullable = false, updatable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "class", nullable = false, updatable = false)
  @Enumerated(value = EnumType.STRING)
  public Class getClazz() {
    return clazz;
  }

  public void setClazz(Class clazz) {
    this.clazz = clazz;
  }

  @Column(name = "level",nullable = false)
  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }
}
