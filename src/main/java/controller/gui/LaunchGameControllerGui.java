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
    }

    public static class WestButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            char initialVillain;

            villain = createVillain();
            initialVillain = getInitials();
            game.moveHero(GlobalVariables.WEST);
            view.newMap(LaunchGameControllerGui.game.pos.getX(),
                    LaunchGameControllerGui.game.pos.getY(),
                    LaunchGameControllerGui.game.map.getX(),
                    LaunchGameControllerGui.game.map.getY(),
                    initialVillain);
            fightOrNotFight();
        }
    }

    public static class EastButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            char initialVillain;

            villain = createVillain();
            initialVillain = getInitials();
            game.moveHero(GlobalVariables.EAST);
            view.newMap(LaunchGameControllerGui.game.pos.getX(),
                    LaunchGameControllerGui.game.pos.getY(),
                    LaunchGameControllerGui.game.map.getX(),
                    LaunchGameControllerGui.game.map.getY(),
                    initialVillain);
            fightOrNotFight();
        }
    }

    public static class NorthButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            char initialVillain;

            villain = createVillain();
            initialVillain = getInitials();
            game.moveHero(GlobalVariables.NORTH);
            view.newMap(LaunchGameControllerGui.game.pos.getX(),
                    LaunchGameControllerGui.game.pos.getY(),
                    LaunchGameControllerGui.game.map.getX(),
                    LaunchGameControllerGui.game.map.getY(),
                    initialVillain);
            fightOrNotFight();
        }
    }

    public static class SouthButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            char initialVillain;

            villain = createVillain();
            initialVillain = getInitials();
            game.moveHero(GlobalVariables.SOUTH);
            view.newMap(LaunchGameControllerGui.game.pos.getX(),
                    LaunchGameControllerGui.game.pos.getY(),
                    LaunchGameControllerGui.game.map.getX(),
                    LaunchGameControllerGui.game.map.getY(),
                    initialVillain);
            fightOrNotFight();
        }


    }

    private static void     fightOrNotFight()
    {
        if (villain != null)
            view.fight(game.hero.getName(), villain.getType());
    }

/*
    public class FightButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            view.fight();
            view.dispose();
        }
    }

    public class RunButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            if (randomFight() == GlobalVariables.FIGHT)
                view.forceToFight();
            view.fight();
            view.dispose();
        }
    }

*/

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
