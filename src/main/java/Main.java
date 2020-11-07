import controller.console.MenuControllerConsole;
import controller.gui.MenuControllerGui;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args[0].equals("console"))
            new MenuControllerConsole();
        else if (args[0].equals("gui"))
            new MenuControllerGui();
        else {
            System.err.println("Error argument");
            System.exit(1);
        }
    }
}