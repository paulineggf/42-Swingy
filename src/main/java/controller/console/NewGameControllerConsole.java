package controller.console;

import controller.ResourceManager;
import model.game.GameModel;
import model.heros.IHero;
import model.heros.SuperHeroFactory;
import view.console.NewGameViewConsole;

import java.util.ArrayList;

class NewGameControllerConsole {

    private NewGameViewConsole newGameView = new NewGameViewConsole();

    NewGameControllerConsole()
    {
        String  type;
        String  artefact;
        String  name;
        IHero   hero;
        ArrayList<GameModel> saveGames;

        try {
            saveGames = ResourceManager.load("./src/main/data/save");
            if (saveGames != null && saveGames.size() == 5)
            {
                newGameView.tooManySavedGame();
                System.console().readLine();
                new MenuControllerConsole();
            }
            else
            {
                type = chooseSuperHero();
                artefact = chooseArtefact();
                name = chooseName();
                hero = SuperHeroFactory.newSuperHero(type, name, artefact);
                new LaunchGameControllerConsole(new GameModel(hero));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String  chooseSuperHero()
    {
        String type;

        newGameView.chooseSuperHero();
        while (true) {
            type = "";
            while (type.equals(""))
                type = System.console().readLine();
            if (type.equals("Spiderman") || type.equals("Superman") || type.equals("Elasticman"))
                return type;
            newGameView.error();
        }
    }

    private String  chooseArtefact()
    {
        String artefact;

        newGameView.chooseArtefact();
        while (true) {
            artefact = "";
            while (artefact.equals(""))
                artefact = System.console().readLine();
            if (artefact.equals("Weapon") || artefact.equals("Armor") || artefact.equals("Helm"))
                return artefact;
            newGameView.error();
        }
    }

    private String  chooseName()
    {
        newGameView.chooseName();
        return System.console().readLine();
    }
}
