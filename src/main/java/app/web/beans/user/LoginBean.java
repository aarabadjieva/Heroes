package app.web.beans.user;

import app.domain.model.binding.UserLoginBinding;
import app.domain.model.service.UserServiceModel;
import app.service.UserService;
import app.web.beans.BaseBean;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@NoArgsConstructor
@Named
@RequestScoped
public class LoginBean extends BaseBean {

    private UserLoginBinding user;
    private UserService userService;

    @Inject
    public LoginBean( UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    private void init(){
        user = new UserLoginBinding();
    }

    public UserLoginBinding getUser() {
        return user;
    }

    public void setUser(UserLoginBinding user) {
        this.user = user;
    }

    public void login(){
        UserServiceModel userServiceModel = userService.login(user);
        if (userServiceModel==null){
            return;
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", userServiceModel.getUsername());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("heroName", "");
        redirect("/home");
    }
}
