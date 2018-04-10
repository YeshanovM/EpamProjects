package model.entity;

import model.entity.enums.*;

public class Bulbous extends Vegetable {

    public Bulbous() {
        super();
        setType(Type.BULBOUS);
    }

    public Bulbous(String name, int caloricity) {
        super(name, caloricity);
        setType(Type.BULBOUS);
    }

    public Bulbous(String name, int caloricity, Taste taste) {
        super(name, caloricity, taste);
        setType(Type.BULBOUS);
    }
}
