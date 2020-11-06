import controller.console.MenuControllerConsole;
//import controller.gui.MenuControllerGui;

public class Main {

    public static void main(String[] args) {
        MenuControllerConsole   menuControllerConsole;
        //MenuControllerGui       menuControllerGui;

        if (args[0].equals("console"))
            menuControllerConsole = new MenuControllerConsole();
        else if (args[0].equals("gui"))
            return;
            //menuControllerGui = new MenuControllerGui();
        else {
            System.err.println("Error argument");
            System.exit(1);
        }
    }
}