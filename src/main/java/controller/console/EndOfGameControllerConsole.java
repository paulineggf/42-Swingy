package controller.console;

import controller.GlobalVariables;
import controller.ResourceManager;
import model.game.GameModel;
import view.console.EndOfGameViewConsole;

import java.io.Serializable;

public class EndOfGameControllerConsole {

    private static GameModel game;
    private static EndOfGameViewConsole endOfGameView = new EndOfGameViewConsole();


    EndOfGameControllerConsole(GameModel game)
    {
        int gamerChoice;

        this.game = game;
        saveGame();
        while (true)
        {
            gamerChoice = continueMenuExit();
            if (gamerChoice == GlobalVariables.MENU)
                new MenuControllerConsole();
            else if (gamerChoice == GlobalVariables.CONTINUE)
                new LaunchGameControllerConsole(game);
            else if (gamerChoice == GlobalVariables.EXIT)
                System.exit(0);
        }
    }

    private static int      continueMenuExit()
    {
        String choice;

        endOfGameView.setView();
        choice = "";
        while (choice.equals("") || (choice.equals("1") == false && choice.equals("2") == false
                && choice.equals("3") == false))
            choice = System.console().readLine();
        return Integer.parseInt(choice);
    }

    private static void     saveGame()
    {
        try {
            ResourceManager.save((Serializable) game, "./src/main/data/save");
            endOfGameView.wellSaved();
        }
        catch (Exception e) {
            System.err.println("Couldn't load save data " + e.getMessage());
        }
    }
}
