package controller.gui;

import controller.GlobalVariables;
import controller.ResourceManager;
import model.game.GameModel;
import model.villains.IVillain;
import model.villains.VillainsFactory;
import view.gui.LaunchGameViewGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class LaunchGameControllerGui {

    private GameModel            game;
    private IVillain             villain;
    private LaunchGameViewGui    view = new LaunchGameViewGui();

    public LaunchGameControllerGui(GameModel game)
    {
        this.game = game;
        this.game.resetMap();
        this.game.hero.resetHitPoints();
        view.newMap(this.game.pos.getX(),
                this.game.pos.getY(),
                this.game.map.getX(),
                this.game.map.getY(),
                ' ');
        view.addNorthButtonListener(new NorthButtonListener());
        view.addSouthButtonListener(new SouthButtonListener());
        view.addEastButtonListener(new EastButtonListener());
        view.addWestButtonListener(new WestButtonListener());
        view.addRunButtonListener(new RunButtonListener());
        view.addFightButtonListener(new FightButtonListener());
        view.addMenuButtonListener(new MenuButtonListener());
        view.addContinueButtonListener(new ContinueButtonListener());
        view.addChangeArtefactButtonListener(new ChangeArtefactButtonListener());
        view.addArtefactValidationButtonListener(new ArtefactValidationButtonListener());
    }

    public class WestButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.WEST);
            move();
        }
    }

    public class EastButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.EAST);
            move();
        }
    }

    public class NorthButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.NORTH);
            move();
        }
    }

    public class SouthButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.moveHero(GlobalVariables.SOUTH);
            move();
        }
    }

    public class ContinueButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            view.dispose();
            view.directionalFrame.dispose();
            new LaunchGameControllerGui(game);
        }
    }

    public class MenuButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            view.dispose();
            view.directionalFrame.dispose();
            new MenuControllerGui();
        }
    }

    public class ChangeArtefactButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            view.artefactFrame.setVisible(true);
            view.changeArtefact(game.hero.getArtefact());
        }
    }

    public class ArtefactValidationButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            game.hero.setArtefact(view.getSelectedArtefact());
            view.artefactFrame.setVisible(false);
            view.directionalFrame.setVisible(true);
        }
    }


    private void     move()
    {
        char initialVillain;

        villain = createVillain();
        initialVillain = getInitials();
        view.newMap(game.pos.getX(),
                game.pos.getY(),
                game.map.getX(),
                game.map.getY(),
                initialVillain);
        if (isEscape())
        {
            saveGame();
            game.experienceUp(villain);
            view.escape();
        }
        fightOrNotFight();
    }

    private boolean  isEscape()
    {
        if (game.pos.getX() == 0 || game.pos.getX() + 1 == game.map.getX()
                || game.pos.getY() == 0 || game.pos.getY() + 1 == game.map.getY()) {
            game.state = GlobalVariables.WONMAP;
            return true;
        }
        return false;
    }

    private void     fightOrNotFight()
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

    private void     fight() {
        // Hero Attack
        view.heroAttack(game.hero.getName(), villain.getType(), game.hero.getAttack());
        game.hero.attack(villain);
        view.getHitPoints(game.hero.getName(), villain.getType(), game.hero.getHitPoints(), villain.getHitPoints());

        // If Villain died = end of battle
        if (villain.getHitPoints() <= 0) {
            view.levelUp(game.experienceUp(villain), game.hero.getName(), game.hero.getLevel());
            return;
        }

        // Villain hit back
        view.villainAttack(game.hero.getName(), villain.getType(), villain.getAttack(), game.hero.getDefense());
        villain.attack(game.hero);
        view.getHitPoints(game.hero.getName(), villain.getType(), game.hero.getHitPoints(), villain.getHitPoints());

        // If Hero died = end of battle
        if (game.hero.getHitPoints() <= 0) {
            game.state = GlobalVariables.GAMEOVER;
            saveGame();
            view.gameOver();
            return;
        }

        // Choice to continue the fight or run away
        view.otherChanceToRunAway();
    }

    private void     saveGame()
    {
        try {
            ResourceManager.save((Serializable) game, "./src/main/data/save");
        }
        catch (Exception e) {
            System.err.println("Couldn't load save data " + e.getMessage());
        }
    }

    private int      randomFight() {
        int random;

        random = (int) ((Math.random() * 2) + 1);
        return random;
    }

    private IVillain createVillain()
    {
        if (game.pos.getX() == 0 || game.pos.getX() + 1 == game.map.getX()
                || game.pos.getY() == 0 || game.pos.getY() + 1 == game.map.getY())
            return null;
        return VillainsFactory.newVillain(villainsRandom());
    }

    private char     getInitials()
    {
        if (villain != null)
            return villain.getInitials();
        return ' ';
    }

    private int      villainsRandom()
    {
        if ((int)((Math.random() * 99) + 1) <= 33 + (game.hero.getLevel() * 2))
            return (int) ((Math.random() * 3) + 1);
        return 0;
    }
}
