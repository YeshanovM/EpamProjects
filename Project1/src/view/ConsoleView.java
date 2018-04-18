package view;

import data.MenuData;
import model.entity.*;

import java.util.ArrayList;
import java.util.Map;

public class ConsoleView {

    private static final String INVITE = "> ";
    private static final String MENU_SEPARATOR = " - ";
    private static final String VEGETABLE_WEIGHT_SEPARATOR = ": ";
    private static final String INVALID_CMD_MESSAGE = "Invalid command or wrong parameters!";
    private static final String NOTHING_TO_SHOW_MESSAGE = "Nothing to show! Generate data first.";

    public static final String TOTAL_CALORICITY_MESSAGE = "Total salad caloricity: ";
    public static final String RELATIVE_CALORICITY_MESSAGE = "Relative salad caloricity: ";
    public static final String NO_VEGETABLES_FOUND = "No suitable vegetables found";

    public ConsoleView() {
    }

    public void showMenu() {
        System.out.println(MenuData.SHOW_MENU.getKey()
                + MENU_SEPARATOR
                + MenuData.SHOW_MENU.getValue()
        );
        System.out.println(MenuData.GENERATE_DATA.getKey()
                + MENU_SEPARATOR
                + MenuData.GENERATE_DATA.getValue()
        );
        System.out.println(MenuData.SHOW_VEGETABLES.getKey()
                + MENU_SEPARATOR
                + MenuData.SHOW_VEGETABLES.getValue()
        );
        System.out.println(MenuData.MAKE_SALAD.getKey()
                + MENU_SEPARATOR
                + MenuData.MAKE_SALAD.getValue()
        );
        System.out.println(MenuData.SHOW_SALAD.getKey()
                + MENU_SEPARATOR
                + MenuData.SHOW_SALAD.getValue()
        );
        System.out.println(MenuData.GET_SALAD_CALORICITY.getKey()
                + MENU_SEPARATOR
                + MenuData.GET_SALAD_CALORICITY.getValue()
        );
        System.out.println(MenuData.SORT_VEGETABLES.getKey()
                + MENU_SEPARATOR
                + MenuData.SORT_VEGETABLES.getValue()
        );
        System.out.println(MenuData.GET_VEGETABLES_BY_CALORIES_RANGE.getKey()
                + MENU_SEPARATOR
                + MenuData.GET_VEGETABLES_BY_CALORIES_RANGE.getValue()
        );
        System.out.println(MenuData.EXIT.getKey()
                + MENU_SEPARATOR
                + MenuData.EXIT.getValue()
        );
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showErrorMessage(String message) {
        System.err.println(message);
    }

    public void invite() {
        System.out.print(INVITE);
    }

    public void showSalad(Salad salad) {
        if(salad == null || salad.getVegetables().size() == 0) {
            System.out.println(NOTHING_TO_SHOW_MESSAGE);
            return;
        }
        for(Map.Entry<Vegetable, Integer> entry : salad.getVegetables().entrySet()) {
            System.out.println(entry.getKey().getName() +
                    VEGETABLE_WEIGHT_SEPARATOR +
                    entry.getValue()
            );
        }
    }

    public void showVegetables(ArrayList<Vegetable> vegetables) {
        if(vegetables == null || vegetables.size() == 0) {
            System.out.println(NOTHING_TO_SHOW_MESSAGE);
            return;
        }
        for(Vegetable v : vegetables) {
            System.out.println(v.getName() +
                    " " + v.getType() +
                    " " + v.getTaste() +
                    " " + v.getCaloricity()
            );
        }
    }

    public void showInvalidCmdMessage() {
        System.out.println(INVALID_CMD_MESSAGE);
        System.out.println(MenuData.SHOW_MENU.getKey()
                + MENU_SEPARATOR
                + MenuData.SHOW_MENU.getValue()
        );
        System.out.println(MenuData.EXIT.getKey()
                + MENU_SEPARATOR
                + MenuData.EXIT.getValue()
        );
    }
}
