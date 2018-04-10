package model.entity;

import model.entity.enums.*;

public class Tuber extends Vegetable {

    public Tuber() {
        super();
        setType(Type.TUBER);
    }

    public Tuber(String name, int caloricity) {
        super(name, caloricity);
        setType(Type.TUBER);
    }

    public Tuber(String name, int caloricity, Taste taste) {
        super(name, caloricity, taste);
        setType(Type.TUBER);
    }
}
