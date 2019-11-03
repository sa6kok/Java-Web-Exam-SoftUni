package web.bean;

import com.mysql.cj.log.Log;
import domain.model.binding.LoginBindingModel;
import org.apache.commons.codec.digest.DigestUtils;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

@Named
public class LoginBean extends BaseBean {
  private UserService userService;
  private LoginBindingModel loginBindingModel;

  public LoginBean() {
  }

  @Inject
  public LoginBean(UserService userService) {
    this.userService = userService;
  }

  @PostConstruct
  public void init() {
    this.loginBindingModel = new LoginBindingModel();
  }

  public LoginBindingModel getLoginBindingModel() {
    return loginBindingModel;
  }

  public void setLoginBindingModel(LoginBindingModel loginBindingModel) {
    this.loginBindingModel = loginBindingModel;
  }

  public void login() {


    try {
      LoginBindingModel user = userService.getUSerWithUsernameAndPassword(loginBindingModel.getUsername(),
          DigestUtils.sha256Hex(loginBindingModel.getPassword()));
      FacesContext.getCurrentInstance().getExternalContext().getSession(true);
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", user.getUsername());
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userId", user.getId());
      this.redirect("/home");
    } catch (NoResultException ex) {
      this.redirect("/login");
    }

  }

}
