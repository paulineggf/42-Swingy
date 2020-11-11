package controller.gui;

import controller.ResourceManager;
import model.game.GameModel;
import view.gui.LoadGameViewGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoadGameControllerGui {

    private LoadGameViewGui view = new LoadGameViewGui();
    private ArrayList<GameModel> saveGames;

    public LoadGameControllerGui()
    {
        String               name;

        view.addMenuButtonListener(new MenuButtonListener());
        view.addValidationButtonListener(new ValidationButtonListener());
        try {
            saveGames = (ArrayList<GameModel>) ResourceManager.load("./src/main/data/save");
            if (saveGames != null)
                view.displayHeros(saveGames);
            else
                view.noCharacterSaved();
            view.setVisible(true);
        }
        catch (Exception e) {
            System.err.println("Couldn't load save data: " + e.getMessage());
        }
    }

    public class ValidationButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            String arr[];
            String hero;

            arr = view.getSelectedHero().split(" ");
            hero = arr[0];
            for (GameModel saveGame: saveGames) {
                if (hero.equals(saveGame.hero.getName()))
                {
                    view.dispose();
                    new LaunchGameControllerGui(saveGame);
                }
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
