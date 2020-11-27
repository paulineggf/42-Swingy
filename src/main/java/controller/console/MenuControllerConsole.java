package controller.console;

import view.console.MenuViewConsole;

public class MenuControllerConsole {

    private MenuViewConsole menuView = new MenuViewConsole();

    public MenuControllerConsole()
    {
        int         gamerChoice;
        String      stringGamerChoice;

        menuView.setVisible();
        while (true)
        {
            stringGamerChoice = "";
            while (stringGamerChoice.equals(""))
                stringGamerChoice = System.console().readLine();
            gamerChoice = Integer.parseInt(stringGamerChoice);
            if (gamerChoice == 1)
                new NewGameControllerConsole();
            else if (gamerChoice == 2)
                new LoadGameControllerConsole();
            else if (gamerChoice == 3)
                System.exit(0);
            else
                menuView.error();
        }
    }
}
