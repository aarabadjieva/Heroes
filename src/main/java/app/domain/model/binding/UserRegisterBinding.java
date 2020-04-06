package app.domain.model.binding;

import app.domain.entity.Country;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterBinding {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private Country country;
}
