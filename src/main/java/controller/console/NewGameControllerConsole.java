package controller.console;

import model.game.GameModel;
import model.heros.IHero;
import model.heros.SuperHeroFactory;
import view.console.NewGameViewConsole;

class NewGameControllerConsole {

    private NewGameViewConsole newGameView = new NewGameViewConsole();

    NewGameControllerConsole()
    {
        String  type;
        String  artefact;
        String  name;
        IHero   hero;
        LaunchGameControllerConsole launchGameControllerConsole;

        type = chooseSuperHero();
        artefact = chooseArtefact();
        name = chooseName();
        hero = SuperHeroFactory.newSuperHero(type, name, artefact);
        launchGameControllerConsole = new LaunchGameControllerConsole(new GameModel(hero));
    }

    private String  chooseSuperHero()
    {
        String type;

        newGameView.chooseSuperHero();
        while (true) {
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
