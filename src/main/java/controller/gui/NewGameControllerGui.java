package controller.gui;

import controller.GlobalVariables;
import controller.console.LaunchGameControllerConsole;
import model.game.GameModel;
import model.heros.IHero;
import model.heros.SuperHeroFactory;
import view.gui.NewGameViewGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameControllerGui {

    private NewGameViewGui view = new NewGameViewGui();

    NewGameControllerGui()
    {
        view.addMenuButtonListener(new MenuButtonListener());
        view.addValidationButtonListener(new ValidationButtonListener());
        view.setVisible(true);
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
