package app.domain.model.service;

import app.domain.entity.Clazz;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroServiceModel {

    private String id;
    private String name;
    private Clazz clazz;
    private int level;
}
