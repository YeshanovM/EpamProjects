package controller;

import data.*;
import utils.ConsoleReader;
import view.ConsoleView;
import model.Model;

import java.util.*;

public class Controller {

    private ConsoleView view;
    private Model model;
    private ConsoleReader reader;

    public Controller(ConsoleView view, Model model) {
        this.view = view;
        this.model = model;
        reader = new ConsoleReader();
    }

    public void run() {
        view.showMenu();
        String[] cmd;
        do {
            view.invite();
            cmd = reader.readCmd();
            if(cmd[0].equals(MenuData.SHOW_MENU.getKey())) {
                view.showMenu();
            }
            else if(cmd[0].equals(MenuData.GENERATE_DATA.getKey())) {
                model.setVegetables(model.getRandomVegetables(
                        new ArrayList<>(Arrays.asList(VegetablesData.VEGETABLES))
                ));
                view.showVegetables(model.getVegetables());
            }
            else if(cmd[0].equals(MenuData.SHOW_VEGETABLES.getKey())) {
                view.showVegetables(model.getVegetables());
            }
            else if(cmd[0].equals(MenuData.MAKE_SALAD.getKey())) {
                model.makeSalad(
                        "Salad",
                        model.getRandomVegetables(model.getVegetables())
                );
                view.showSalad(model.getSalad());
            }
            else if(cmd[0].equals(MenuData.SHOW_SALAD.getKey())) {
                view.showSalad(model.getSalad());
            }
            else if(cmd[0].equals(MenuData.GET_SALAD_CALORICITY.getKey())) {
                view.showMessage(ConsoleView.TOTAL_CALORICITY_MESSAGE + model.getTotalSaladCaloricity());
                view.showMessage(ConsoleView.RELATIVE_CALORICITY_MESSAGE + model.getRelativeSaladCaloricity());
            }
            else if(cmd[0].equals(MenuData.SORT_VEGETABLES.getKey())) {
                model.sortVegetablesByCaloricity();
                view.showVegetables(model.getVegetables());
            }
            else if(cmd[0].equals(MenuData.GET_VEGETABLES_BY_CALORIES_RANGE.getKey())) {
                //TODO
            }
            else if(!cmd[0].equals(MenuData.EXIT.getKey())) {
                view.showInvalidCmdMessage();
            }
        } while(!cmd[0].equals(MenuData.EXIT.getKey()));
    }
}
