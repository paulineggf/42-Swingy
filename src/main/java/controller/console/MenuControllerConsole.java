package controller.console;

import view.console.MenuViewConsole;

public class MenuControllerConsole {

    private MenuViewConsole menuView = new MenuViewConsole();

    public MenuControllerConsole()
    {
        int                         gamerChoice;
        NewGameControllerConsole    newGame;
        LoadGameControllerConsole   loadGameController;
        while (true)
        {
            menuView.setVisible();
            gamerChoice = Integer.parseInt(System.console().readLine());
            if (gamerChoice == 1)
                newGame = new NewGameControllerConsole();
            else if (gamerChoice == 2)
                loadGameController = new LoadGameControllerConsole();
            else if (gamerChoice == 3)
                System.exit(0);
            else
                menuView.error();
        }
    }
}
