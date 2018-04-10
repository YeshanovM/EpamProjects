package model.entity;

import model.entity.enums.*;

public class Nightshade extends Vegetable {

    public Nightshade() {
        super();
        setType(Type.NIGHTSHADE);
    }

    public Nightshade(String name, int caloricity) {
        super(name, caloricity);
        setType(Type.NIGHTSHADE);
    }

    public Nightshade(String name, int caloricity, Taste taste) {
        super(name, caloricity, taste);
        setType(Type.NIGHTSHADE);
    }
}
