package app.web.beans.user;

import app.domain.model.binding.UserRegisterBinding;
import app.domain.model.service.UserServiceModel;
import app.service.UserService;
import app.web.beans.BaseBean;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@NoArgsConstructor
@Named
@RequestScoped
public class RegisterBean extends BaseBean {

    private ModelMapper modelMapper;
    private UserService userService;
    private UserRegisterBinding user;

    @Inject
    public RegisterBean(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @PostConstruct
    private void init(){
        user = new UserRegisterBinding();
    }

    public UserRegisterBinding getUser() {
        return user;
    }

    public void setUser(UserRegisterBinding user) {
        this.user = user;
    }

    public void register(){
        if (!user.getPassword().equals(user.getConfirmPassword())){
            return;
        }
        UserServiceModel userServiceModel = modelMapper.map(user, UserServiceModel.class);
        try {
            userService.register(userServiceModel);
            redirect("/users/login");
        }catch (Exception e){
            redirect("/users/register");
        }
    }
}
