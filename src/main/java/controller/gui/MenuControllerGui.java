package controller.gui;

import view.GuiMenuView;

import javax.swing.event.MenuListener;

public class MenuControllerGui {

    MenuViewGui    menuView = MenuViewGui();

    public MenuControllerGui()
    {
        menuView.addNewGameButtonListener(new NewGameButtonListener());
        menuView.addLoadGameButtonListener(new LoadGameButtonListener());
        menuView.setVisible(true);
    }

    class NewGameButtonListener implements ActionListener {

        public void     actionPerformed(ActionEvent event) {
            try
            {
                NewGameController newGameController = NewGameController();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class LoadGameButtonListener implements ActionListener {

        public void     actionPerformed(ActionEvent event) {
            try
            {
                LoadGameController loadGameController = new LoadGameController();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
