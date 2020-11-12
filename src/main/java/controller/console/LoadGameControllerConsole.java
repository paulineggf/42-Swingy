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
        String[]                    arr;
        String                      name;
        ArrayList<GameModel>        saveGames;

        try {
            saveGames = (ArrayList<GameModel>)ResourceManager.load("./src/main/data/save");
            if (saveGames != null && saveGames.size() > 0)
            {
                loadGameView.displayCharacters(saveGames);
                while (true)
                {
                    name = System.console().readLine();
                    arr = name.split(" ");
                    for (GameModel saveGame: saveGames) {
                        if (arr[0].equals("menu"))
                            new MenuControllerConsole();
                        else if (arr.length > 1 && arr[1].equals("delete") && arr[0].equals(saveGame.hero.getName()))
                        {
                            ResourceManager.removeGame(arr[0], "./src/main/data/save");
                            new LoadGameControllerConsole();
                        }
                        if (arr[0].equals(saveGame.hero.getName()) && saveGame.state == GlobalVariables.GAMEOVER)
                        {
                            loadGameView.characterGameOver();
                            loadGameView.error();
                            continue;
                        }
                        else if (arr[0].equals(saveGame.hero.getName()))
                            new LaunchGameControllerConsole(saveGame);
                    }
                    loadGameView.characterNotExit();
                    loadGameView.error();
                }
            }
            else {
                loadGameView.noCharacterSaved();
                System.console().readLine();
                new MenuControllerConsole();
            }
        }
        catch (Exception e) {
            System.err.println("Couldn't load save data: " + e.getMessage());
        }
    }
}
