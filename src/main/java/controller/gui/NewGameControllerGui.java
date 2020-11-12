package controller.gui;

import controller.GlobalVariables;
import controller.ResourceManager;
import controller.console.LaunchGameControllerConsole;
import model.game.GameModel;
import model.heros.IHero;
import model.heros.SuperHeroFactory;
import view.gui.NewGameViewGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewGameControllerGui {

    private NewGameViewGui view = new NewGameViewGui();

    NewGameControllerGui()
    {
        ArrayList<GameModel> saveGames;

        view.addMenuButtonListener(new MenuButtonListener());
        view.addValidationButtonListener(new ValidationButtonListener());
        try {
            saveGames = ResourceManager.load("./src/main/data/save");
            if (saveGames != null && saveGames.size() == 5)
                view.tooManySavedGame();
            else
                view.newGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class ValidationButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            String      type;
            String[]    artefact;
            String      name;
            IHero       hero;

            type = view.getSelectedHero();
            artefact = view.getSelectedArtefact().split(" ");
            name = view.getName();
            hero = SuperHeroFactory.newSuperHero(type, name, artefact[0]);
            view.dispose();
            new LaunchGameControllerGui(new GameModel(hero));
        }
    }

    public class MenuButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            view.dispose();
            new MenuControllerGui();
        }
    }
}
