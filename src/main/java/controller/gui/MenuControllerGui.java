package controller.gui;

import view.gui.MenuViewGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuControllerGui {

    MenuViewGui    view = new MenuViewGui();

    public MenuControllerGui() {
        view.addNewGameButtonListener(new NewGameButtonListener());
        view.addLoadGameButtonListener(new LoadGameButtonListener());
        view.setVisible(true);
    }
    public class NewGameButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            new NewGameControllerGui();
            view.dispose();
        }
    }

    public class LoadGameButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            new LoadGameControllerGui();
            view.dispose();
        }
    }
}
