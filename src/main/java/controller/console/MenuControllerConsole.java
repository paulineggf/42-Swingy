package controller.console;

import view.console.MenuViewConsole;

public class MenuControllerConsole {

    private MenuViewConsole menuView = new MenuViewConsole();

    public MenuControllerConsole()
    {
        int     gamerChoice;

        while (true)
        {
            menuView.setVisible();
            gamerChoice = Integer.parseInt(System.console().readLine());
            if (gamerChoice == 1)
                NewGameControllerConsole newGame = new NewGameControllerConsole();
            else if (gamerChoice == 2)
                LoadGameController loadGameController = new loadGameController();
            else if (gamerChoice == 3)
                System.exit(0);
            else
                menuView.error();
        }
    }
}
