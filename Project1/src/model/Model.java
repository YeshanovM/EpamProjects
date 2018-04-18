package model;

import model.entity.*;

import java.util.*;

public class Model {

    private Salad salad;
    private ArrayList<Vegetable> vegetables;

    public Model() {
        vegetables = new ArrayList<>();
    }

    public boolean addVegetable(Vegetable vegetable) {
        vegetables.add(vegetable);
        return true;
    }

    public boolean removeVegetable(Vegetable vegetable) {
        return vegetables.remove(vegetable);
    }

    public void makeSalad(String name, ArrayList<Vegetable> vegetables, ArrayList<Integer> weights) {
        HashMap<Vegetable, Integer> vegetablesHashMap = new HashMap<>();
        for(int i = 0; i < vegetables.size(); i++) {
            if(vegetablesHashMap.containsKey(vegetables.get(i))) {
                vegetablesHashMap.put(vegetables.get(i),
                        weights.get(i) + vegetablesHashMap.get(vegetables.get(i)));
            }
            else {
                vegetablesHashMap.put(vegetables.get(i), weights.get(i));
            }
        }
        makeSalad(name, vegetablesHashMap);
    }

    public void makeSalad(String name, HashMap<Vegetable, Integer> vegetables) {
        salad = new Salad(name, vegetables);
    }

    public void makeSalad(String name, ArrayList<Vegetable> vegetables) {
        HashMap<Vegetable, Integer> vegetablesMap = new HashMap<>();
        for(Vegetable vegetable : vegetables) {
            vegetablesMap.put(vegetable, (int)(Math.random() * 100));
        }
        makeSalad(name, vegetablesMap);
    }

    public int getTotalSaladCaloricity() {
        if(salad == null)
            return 0;
        int caloricity = 0;
        HashMap<Vegetable, Integer> vegetables = salad.getVegetables();
        for(Vegetable vegetable : vegetables.keySet()) {
            caloricity += vegetable.getCaloricity() * vegetables.get(vegetable);
        }
        return caloricity;
    }

    public int getRelativeSaladCaloricity() {
        if(salad == null || salad.getVegetables().size() == 0)
            return 0;
        int totalWeight = 0;
        for(Integer weight : salad.getVegetables().values())
            totalWeight += weight;
        return (getTotalSaladCaloricity() / totalWeight);
    }

    public void sortVegetablesByCaloricity() {
        vegetables.sort(Comparator.comparingInt(Vegetable::getCaloricity));
    }

    public ArrayList<Vegetable> getSaladVegetablesByCaloricity(int min, int max) {
        Vegetable[] array = (Vegetable[])salad.getVegetables().keySet().stream()
                .filter(vegetable -> (vegetable.getCaloricity() >= min && vegetable.getCaloricity() <= max)
        ).toArray();
        return new ArrayList<>(Arrays.asList(array));
    }

    public Salad getSalad() {
        return salad;
    }

    public void setSalad(Salad salad) {
        this.salad = salad;
    }

    public ArrayList<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(ArrayList<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }

    public ArrayList<Vegetable> getRandomVegetables(ArrayList<Vegetable> source) {
        ArrayList<Vegetable> vegetables = new ArrayList<>();
        int count = (int)((Math.random() / 2 + 0.5) * source.size());
        for(int i = 0; i < count; i++) {
            int index = (int)(Math.random() * source.size());
            while(vegetables.contains(source.get(index))) {
                index = (int)(Math.random() * source.size());
            }
            vegetables.add(source.get(index));
        }
        return vegetables;
    }
}
