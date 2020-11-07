package controller.gui;

import view.gui.MenuViewGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuControllerGui {

    MenuViewGui    menuView = new MenuViewGui();

    public MenuControllerGui() throws IOException {
        menuView.addNewGameButtonListener(new NewGameButtonListener());
        menuView.addLoadGameButtonListener(new LoadGameButtonListener());
        menuView.setVisible(true);
    }
    public class NewGameButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            new NewGameControllerGui();
        }
    }

    public class LoadGameButtonListener implements ActionListener {
        public void     actionPerformed(ActionEvent event) {
            new LoadGameControllerGui();
        }
    }
}
