package model.entity;

import java.util.*;

public class Salad {
    private String name;
    private HashMap<Vegetable, Integer> vegetables;

    public Salad() {
        vegetables = new HashMap<>();
    }

    public Salad(String name) {
        this.name = name;
    }

    public Salad(String name, HashMap<Vegetable, Integer> vegetables) {
        this(name);
        this.vegetables = vegetables;
    }

    public void addVegetable(Vegetable vegetable, int weight) {
        if(vegetables.containsKey(vegetable)) {
            vegetables.put(vegetable, vegetables.get(vegetable) + weight);
        }
        else {
            vegetables.put(vegetable, weight);
        }
    }

    public HashMap<Vegetable, Integer> getVegetables() {
        return vegetables;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Salad{" +
                "name='" + name + '\'' +
                ", vegetables=" + vegetables +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salad)) return false;
        Salad salad = (Salad) o;
        return Objects.equals(name, salad.name) &&
                Objects.equals(vegetables, salad.vegetables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vegetables);
    }
}