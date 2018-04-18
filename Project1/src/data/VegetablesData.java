package data;

import model.entity.*;
import model.entity.enums.Taste;

public class VegetablesData {
    public static Vegetable[] VEGETABLES = {
            new Root("Carrot", 10, Taste.SWEET),
            new Beans("Pace", 20, Taste.SWEET),
            new Cabbage("Cabbage", 10, Taste.SWEET)
    };
}
