package app.domain.model.binding;

import app.domain.entity.Clazz;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroCreateBinding {

    private String name;
    private Clazz clazz;
    private int level;
}
