import controller.console.MenuControllerConsole;
import controller.gui.MenuControllerGui;

public class Main {

    public static void main(String[] args) {
        if (args[0].equals("console"))
            MenuControllerConsole menuControllerConsole = new MenuControllerConsole();
        else if (args[0].equals("gui"))
            MenuControllerGui menuControllerGui = new MenuControllerGui();
        else {
            System.err.println("Error argument");
            System.exit(1);
        }
    }
}