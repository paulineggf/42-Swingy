package controller.gui;

import controller.GlobalVariables;
import controller.ResourceManager;
import model.game.GameModel;
import view.gui.EndOfGameViewGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class EndOfGameControllerGui {

    private static EndOfGameViewGui view = new EndOfGameViewGui();
    private static GameModel game;

    public EndOfGameControllerGui(GameModel game)
    {
        this.game = game;
        saveGame();
        view.addContinueButtonListener(new ContinueButtonListener());
        view.addMenuButtonListener(new MenuButtonListener());
        view.visible(game.state);
        view.setVisible(true);
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

    public static class ContinueButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            new LaunchGameControllerGui(game);
            view.dispose();
        }
    }

    public static class MenuButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            new MenuControllerGui();
            view.dispose();
        }
    }
}
