package web.bean;

import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
public class LogoutBean extends BaseBean {
  public void logout() {
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    this.redirect("/index");
  }
}
