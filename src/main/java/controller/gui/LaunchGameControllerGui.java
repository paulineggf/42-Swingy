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
    private static LaunchGameViewGui    view;

    public LaunchGameControllerGui(GameModel game, IVillain villain)
    {
        if (villain != null)
            LaunchGameControllerGui.villain = villain;
        LaunchGameControllerGui.game = game;

        char initialVillain;
        if (villain != null)
            initialVillain = villain.getInitials();
        else
            initialVillain = ' ';
        view = new LaunchGameViewGui(LaunchGameControllerGui.game.pos.getX(),
                LaunchGameControllerGui.game.pos.getY(),
                LaunchGameControllerGui.game.map.getX(),
                LaunchGameControllerGui.game.map.getY(),
                initialVillain);
        view.addNorthButtonListener(new NorthButtonListener());
        view.addSouthButtonListener(new SouthButtonListener());
        view.addEastButtonListener(new EastButtonListener());
        view.addWestButtonListener(new WestButtonListener());
        view.setVisible(true);
    }

    public static class WestButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.WEST);
            view.directional.dispose();
            view.dispose();
            new LaunchGameControllerGui(game, createVillain());
        }
    }

    public static class EastButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.EAST);
            view.directional.dispose();
            view.dispose();
            new LaunchGameControllerGui(game, createVillain());
        }
    }

    public static class NorthButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.NORTH);
            view.directional.dispose();
            view.dispose();
            new LaunchGameControllerGui(game, createVillain());
        }
    }

    public static class SouthButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.SOUTH);
            view.directional.dispose();
            view.dispose();
            new LaunchGameControllerGui(game, createVillain());
        }
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

    private static int      villainsRandom()
    {
        if ((int)((Math.random() * 99) + 1) <= 33 + (game.hero.getLevel() * 2))
            return (int) ((Math.random() * 3) + 1);
        return 0;
    }
}
