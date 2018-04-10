package model.entity;

import model.entity.enums.*;

public class Root extends Vegetable {

    public Root() {
        super();
        setType(Type.ROOT);
    }

    public Root(String name, int caloricity) {
        super(name, caloricity);
        setType(Type.ROOT);
    }

    public Root(String name, int caloricity, Taste taste) {
        super(name, caloricity, taste);
        setType(Type.ROOT);
    }
}
