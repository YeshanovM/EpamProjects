import controller.Controller;
import model.Model;
import view.ConsoleView;

public class Runner {

    public static void run() {
        Model model = new Model();
        ConsoleView view = new ConsoleView();
        Controller controller = new Controller(view, model);
        controller.run();
    }
}
