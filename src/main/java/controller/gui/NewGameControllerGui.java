package controller.gui;

import controller.ResourceManager;
import model.game.GameModel;
import model.heros.IHero;
import model.heros.SuperHeroFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import view.gui.NewGameViewGui;

import javax.swing.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

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
            String      artefact;
            String      name;
            IHero       hero;

            try {
                type = view.getSelectedHero();
                artefact = view.getSelectedArtefact();
                name = view.getName();
                ValidatorFactory validatorFactory = Validation.byDefaultProvider()
                        .configure()
                        .messageInterpolator(new ParameterMessageInterpolator())
                        .buildValidatorFactory();
                Validator validator = validatorFactory.getValidator();
                hero = SuperHeroFactory.newSuperHero(type, name, artefact);
                Set<ConstraintViolation<IHero>> constraintViolations = validator.validate(hero);
                if (constraintViolations.isEmpty()) {
                    view.dispose();
                    new LaunchGameControllerGui(new GameModel(hero));
                }
                else {
                    String error = "";
                    for (ConstraintViolation<IHero> constraintViolation : constraintViolations)
                        error += constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage() + "\n";
                    JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class MenuButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            view.dispose();
            new MenuControllerGui();
        }
    }
}
