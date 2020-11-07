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

    private NewGameViewGui newGameView = new NewGameViewGui();

    NewGameControllerGui()
    {
        newGameView.addValidationButtonListener(new ValidationButtonListener());
        newGameView.setVisible(true);
    }

    public class ValidationButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            String  type;
            String  artefact;
            String  name;
            IHero hero;

            if (newGameView.getSpidermanRadioButton())
                type = "spiderman";
            else if (newGameView.getSupermanRadioButton())
                type = "superman";
            else if (newGameView.getElasticmanRadioButton())
                type = "elasticman";
            else
                type = "";
            if (newGameView.getArmorRadioButton())
                artefact = "armor";
            else if (newGameView.getHelmRadioButton())
                artefact = "helm";
            else if (newGameView.getWeaponRadioButton())
                artefact = "weapon";
            else
                artefact = "";
            name = newGameView.getName();
            hero = SuperHeroFactory.newSuperHero(type, name, artefact);
            new LaunchGameControllerConsole(new GameModel(hero));
        }
    }
}
