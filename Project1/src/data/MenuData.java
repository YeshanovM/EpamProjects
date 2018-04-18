package data;

import javafx.util.*;

public class MenuData {
    public static final Pair<String, String> SHOW_MENU = new Pair<>("1", "show menu");
    public static final Pair<String, String> GENERATE_DATA = new Pair<>("2", "generate data");
    public static final Pair<String, String> SHOW_VEGETABLES = new Pair<>("3", "show available vegetables");
    public static final Pair<String, String> MAKE_SALAD = new Pair<>("4", "make salad from RANDOM vegetables with RANDOM weights");
    public static final Pair<String, String> SHOW_SALAD = new Pair<>("5", "show salad");
    public static final Pair<String, String> GET_SALAD_CALORICITY = new Pair<>("6", "count salad caloricity");
    public static final Pair<String, String> SORT_VEGETABLES = new Pair<>("7", "sort vegetables by caloricity");
    public static final Pair<String, String> GET_VEGETABLES_BY_CALORIES_RANGE = new Pair<>("8", "get vegetables in salad by caloricity range. Parameters: <min max>");
    public static final Pair<String, String> EXIT = new Pair<>("9", "exit");
}
