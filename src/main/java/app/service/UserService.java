package app.service;

import app.domain.model.binding.UserLoginBinding;
import app.domain.model.service.UserServiceModel;

public interface UserService {

    void register(UserServiceModel user);

    UserServiceModel login(UserLoginBinding user);
}
