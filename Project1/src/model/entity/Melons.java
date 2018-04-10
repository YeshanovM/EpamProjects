package model.entity;

import model.entity.enums.*;

public class Melons extends Vegetable {

    public Melons() {
        super();
        setType(Type.MELONS);
    }

    public Melons(String name, int caloricity) {
        super(name, caloricity);
        setType(Type.MELONS);
    }

    public Melons(String name, int caloricity, Taste taste) {
        super(name, caloricity, taste);
        setType(Type.MELONS);
    }
}
