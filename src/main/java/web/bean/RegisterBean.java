package web.bean;

import domain.model.binding.UserBindingModel;
import org.apache.commons.codec.digest.DigestUtils;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

@Named
public class RegisterBean extends BaseBean {
  private UserService userService;
  private UserBindingModel userBindingModel;

  public RegisterBean() {
  }

  @Inject
  public RegisterBean(UserService userService) {
    this.userService = userService;
  }

  @PostConstruct
  private void init() {
    this.userBindingModel = new UserBindingModel();
  }

  public UserBindingModel getUserBindingModel() {
    return userBindingModel;
  }

  public void setUserBindingModel(UserBindingModel userBindingModel) {
    this.userBindingModel = userBindingModel;
  }

  public void save() {

    try {
      userService.getUSerWithUsername(userBindingModel.getUsername());
      super.redirect("/login");
    } catch (NoResultException ex) {
      if (userBindingModel.getPassword().equals(userBindingModel.getConfirmPassword())) {
        this.userBindingModel.setPassword(DigestUtils.sha256Hex(this.userBindingModel.getPassword()));
        userService.save(userBindingModel);
        super.redirect("/login");
      } else {
        super.redirect("/register");
      }
    }
  }
}
