package app.web.beans.user;

import app.web.beans.BaseBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LogoutBean extends BaseBean {

    public void logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        redirect("/");
    }
}
