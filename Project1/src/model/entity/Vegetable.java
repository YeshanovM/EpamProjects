package model.entity;

import model.entity.enums.*;

import java.util.Objects;

public abstract class Vegetable {

    private String name;
    private int caloricity;
    private Taste taste;
    private Type type;

    public Vegetable() {
    }

    public Vegetable(String name, int caloricity) {
        this();
        this.name = name;
        this.caloricity = caloricity;
    }

    public Vegetable(String name, int caloricity, Taste taste) {
        this(name, caloricity);
        this.taste = taste;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCaloricity() {
        return caloricity;
    }

    public void setCaloricity(int caloricity) {
        this.caloricity = caloricity;
    }

    public Taste getTaste() {
        return taste;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }

    void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vegetable)) return false;
        Vegetable vegetable = (Vegetable) o;
        return caloricity == vegetable.caloricity &&
                Objects.equals(name, vegetable.name) &&
                taste == vegetable.taste &&
                type == vegetable.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, caloricity, taste, type);
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "name='" + name + '\'' +
                ", caloricity=" + caloricity +
                ", taste=" + taste +
                ", type=" + type +
                '}';
    }
}