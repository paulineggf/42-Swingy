package controller.gui;

import controller.GlobalVariables;
import model.game.GameModel;
import model.villains.IVillain;
import model.villains.VillainsFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchGameControllerGui {

    private static GameModel            game;
    private static IVillain             villain;
    private static LaunchGameViewGui    view = new LaunchGameViewGui();

    public LaunchGameControllerGui(GameModel game, IVillain villain)
    {
        this.villain = villain;
        this.game = game;
        if (villain != null)
            view.displayMap(game.pos.getX(), game.pos.getY(), game.map.getX(), game.map.getY(), false, ' ');
        else
            view.displayMap(game.pos.getX(), game.pos.getY(), game.map.getX(), game.map.getY(), true, villain.getInitials());
        view.setVisible(true);
    }

    public class WestButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.WEST);
            new LaunchGameControllerGui(game, createVillain());
            view.dispose();
        }
    }

    public class EastButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.EAST);
            new LaunchGameControllerGui(game, createVillain());
            view.dispose();
        }
    }

    public class NorthButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.NORTH);
            new LaunchGameControllerGui(game, createVillain());
            view.dispose();
        }
    }

    public class SouthButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.SOUTH);
            new LaunchGameControllerGui(game, createVillain());
            view.dispose();
        }
    }

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
