package model.entity;

import model.entity.enums.*;

public class Cabbage extends Vegetable {

    public Cabbage() {
        super();
        setType(Type.CABBAGE);
    }

    public Cabbage(String name, int caloricity) {
        super(name, caloricity);
        setType(Type.CABBAGE);
    }

    public Cabbage(String name, int caloricity, Taste taste) {
        super(name, caloricity, taste);
        setType(Type.CABBAGE);
    }
}
