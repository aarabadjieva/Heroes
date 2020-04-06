package app.domain.model.service;

import app.domain.entity.Country;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserServiceModel {

    private String username;
    private String password;
    private String email;
    private Country country;
}
