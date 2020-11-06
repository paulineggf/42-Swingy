package controller.console;

import controller.GlobalVariables;
import model.game.GameModel;
import model.villains.IVillain;
import model.villains.VillainsFactory;
import view.Console;
import view.console.LaunchGameViewConsole;

public class LaunchGameControllerConsole {

    private static GameModel game;
    private static LaunchGameViewConsole launchGameView = new LaunchGameViewConsole();

    public LaunchGameControllerConsole(GameModel game)
    {
        IVillain        newVillain;
        //FightController fightController;

        this.game = game;
        newVillain = null;
        game.resetMap();
        launchGameView.displayMap(game.pos.getX(), game.pos.getY(), game.map.getX(), game.map.getY(), ' ');
        game.state = GlobalVariables.PROGRESS;
        while (game.state == GlobalVariables.PROGRESS) {
            if (newVillain != null) {
                launchGameView.displayMap(game.pos.getX(), game.pos.getY(), game.map.getX(), game.map.getY(), newVillain.getInitials());
            }
            moveHero();
            newVillain = createVillain();
            if (newVillain != null)
                launchGameView.displayMap(game.pos.getX(), game.pos.getY(), game.map.getX(), game.map.getY(), newVillain.getInitials());
            else
                launchGameView.displayMap(game.pos.getX(), game.pos.getY(), game.map.getX(), game.map.getY(),' ');
            //if (newVillain != null)
            //fightController = new FightController(newVillain);
            newVillain = null;
        }
        resultGame();
    }

    private static void     moveHero()
    {
        int             moveHero;
        String          line;

        launchGameView.moveHero();
        line = "";
        while (true)
        {
            while (line == "")
                line = System.console().readLine();
            moveHero = Integer.parseInt(line);
            if (moveHero != GlobalVariables.NORTH
                    && moveHero != GlobalVariables.SOUTH
                    && moveHero != GlobalVariables.WEST
                    && moveHero != GlobalVariables.EAST) {
                line = "";
                continue;
            }
            break;
        }
        game.moveHero(moveHero);
    }

    private static IVillain createVillain()
    {
        return VillainsFactory.newVillain(villainsRandom());
    }

    private static int      villainsRandom()
    {
        if ((int)((Math.random() * 99) + 1) <= 33 + (game.hero.getLevel() * 2))
            return (int) ((Math.random() * 3) + 1);
        return 0;
    }

    private static void     resultGame()
    {
        if (game.hero.getLevel() == 5 && game.state != GlobalVariables.GAMEOVER)
        {
            launchGameView.won(game.hero.getName());
            game.state = GlobalVariables.WON;
        }
    }
}
