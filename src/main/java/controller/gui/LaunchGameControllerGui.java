package controller.gui;

import controller.GlobalVariables;
import model.game.GameModel;
import model.villains.IVillain;
import model.villains.VillainsFactory;
import view.gui.LaunchGameViewGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchGameControllerGui {

    private static GameModel            game;
    private static IVillain             villain;
    private static LaunchGameViewGui    view = new LaunchGameViewGui();

    public LaunchGameControllerGui(GameModel game)
    {
        LaunchGameControllerGui.game = game;

        game.resetMap();
        view.newMap(LaunchGameControllerGui.game.pos.getX(),
                LaunchGameControllerGui.game.pos.getY(),
                LaunchGameControllerGui.game.map.getX(),
                LaunchGameControllerGui.game.map.getY(),
                ' ');
        view.addNorthButtonListener(new NorthButtonListener());
        view.addSouthButtonListener(new SouthButtonListener());
        view.addEastButtonListener(new EastButtonListener());
        view.addWestButtonListener(new WestButtonListener());
        view.addRunButtonListener(new RunButtonListener());
        view.addFightButtonListener(new FightButtonListener());
    }

    public static class WestButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.WEST);
            move();
        }
    }

    public static class EastButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.EAST);
            move();
        }
    }

    public static class NorthButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.NORTH);
            move();
        }
    }

    public static class SouthButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.SOUTH);
            move();
        }
    }

    private static void     move()
    {
        char initialVillain;

        villain = createVillain();
        initialVillain = getInitials();
        view.newMap(LaunchGameControllerGui.game.pos.getX(),
                LaunchGameControllerGui.game.pos.getY(),
                LaunchGameControllerGui.game.map.getX(),
                LaunchGameControllerGui.game.map.getY(),
                initialVillain);
        fightOrNotFight();
        if (isEscape() == true)
            new EndOfGameControllerGui(game);
    }

    private static boolean  isEscape()
    {
        if (game.pos.getX() == 0 || game.pos.getX() + 1 == game.map.getX()
                || game.pos.getY() == 0 || game.pos.getY() + 1 == game.map.getY())
        {
            game.state = GlobalVariables.WONMAP;
            return true;
        }
        return false;
    }

    private static void     fightOrNotFight()
    {
        if (villain != null)
            view.fight(game.hero.getName(), villain.getType());
    }

    public class FightButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            fight();
        }
    }

    public class RunButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            if (randomFight() == GlobalVariables.FIGHT)
            {
                view.forceToFight();
                fight();
            }
            else
                view.runAway();
        }
    }

    private static void     fight() {
        while (true)
        {
            // Hero Attack
            view.heroAttack(game.hero.getName(), villain.getType(), game.hero.getAttack());
            game.hero.attack(villain);
            view.getHitPoints(game.hero.getName(), villain.getType(), game.hero.getHitPoints(), villain.getHitPoints());

            // If Villain died = end of battle
            if (villain.getHitPoints() <= 0) {
                game.experienceUp(villain);
                view.levelUp(game.hero.getName(), game.hero.getLevel());
                break;
            }

            // Villain hit back
            view.villainAttack(game.hero.getName(), villain.getType(), villain.getAttack(), game.hero.getDefense());
            villain.attack(game.hero);
            view.getHitPoints(game.hero.getName(), villain.getType(), game.hero.getHitPoints(), villain.getHitPoints());

            // If Hero died = end of battle
            if (game.hero.getHitPoints() <= 0) {
                game.state = GlobalVariables.GAMEOVER;
                break;
            }

            // Choice to continue the fight or run away
            view.otherChanceToRunAway();
        }
    }

    private static int      randomFight() {
        int random;

        random = (int) ((Math.random() * 2) + 1);
        return random;
    }

    private static IVillain createVillain()
    {
        return VillainsFactory.newVillain(villainsRandom());
    }

    private static char     getInitials()
    {
        if (villain != null)
            return villain.getInitials();
        return ' ';
    }

    private static int      villainsRandom()
    {
        if ((int)((Math.random() * 99) + 1) <= 33 + (game.hero.getLevel() * 2))
            return (int) ((Math.random() * 3) + 1);
        return 0;
    }
}
