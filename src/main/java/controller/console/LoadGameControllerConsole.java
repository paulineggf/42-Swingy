package controller.console;

import controller.GlobalVariables;
import model.game.GameModel;
import controller.ResourceManager;
import view.console.LoadGameViewConsole;

import java.util.ArrayList;

public class LoadGameControllerConsole {

    private LoadGameViewConsole loadGameView = new LoadGameViewConsole();

    LoadGameControllerConsole()
    {
        String                      name;
        ArrayList<GameModel>             saveGames;

        try {
            saveGames = (ArrayList<GameModel>)ResourceManager.load("./src/main/data/save");
            if (saveGames != null)
            {
                loadGameView.displayCharacters(saveGames);
                while (true)
                {
                    name = System.console().readLine();
                    for (GameModel saveGame: saveGames) {
                        if (name.equals(saveGame.hero.getName()) && saveGame.state == GlobalVariables.GAMEOVER)
                        {
                            loadGameView.characterGameOver();
                            loadGameView.error();
                            continue;
                        }
                        else if (name.equals(saveGame.hero.getName()))
                            new LaunchGameControllerConsole(saveGame);
                    }
                    loadGameView.characterNotExit();
                    loadGameView.error();
                }
            }
            else
                loadGameView.noCharacterSaved();
        }
        catch (Exception e) {
            System.err.println("Couldn't load save data: " + e.getMessage());
        }
    }
}
