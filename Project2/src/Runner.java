import controller.Controller;
import model.Model;
import view.ConsoleView;

public class Runner {
    public static void run() {
        ConsoleView view = new ConsoleView();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.run();
    }
}
