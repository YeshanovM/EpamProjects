package model.entity;

import model.entity.enums.*;

public class Beans extends Vegetable {

    public Beans() {
        super();
        setType(Type.BEANS);
    }

    public Beans(String name, int caloricity) {
        super(name, caloricity);
        setType(Type.BEANS);
    }

    public Beans(String name, int caloricity, Taste taste) {
        super(name, caloricity, taste);
        setType(Type.BEANS);
    }
}
