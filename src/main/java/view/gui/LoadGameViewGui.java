package view.gui;

import model.game.GameModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

public class LoadGameViewGui extends JFrame {
    JPanel      panel = new JPanel();
    JLabel      chooseAHeroLabel = new JLabel("Choose a SuperHero:");
    JLabel      noCharacterSaved = new JLabel("No character saved");
    ButtonGroup bgCharacters = new ButtonGroup();
    JButton     validationButton = new JButton("OK");
    JButton     menuButton = new JButton("Menu");

    public LoadGameViewGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        panel.setLayout(null);
        panel.setBounds(400, 400, 500, 500);
        menuButton.setBounds(5, 5, 100, 30);
        panel.add(menuButton);
    }

    public void     displayHeros(ArrayList<GameModel> saveGames) {
        int y;

        y = 50;
        chooseAHeroLabel.setBounds(100, 30, 200, 20);
        for (GameModel saveGame: saveGames) {
            JRadioButton radioButton = new JRadioButton(saveGame.hero.getName());
            radioButton.setBounds(100, y, 200, 20);
            bgCharacters.add(radioButton);
            panel.add(radioButton);
            y += 20;
        }
        validationButton.setBounds(100, y + 10, 100, 30);
        panel.add(validationButton);
        panel.add(chooseAHeroLabel);
        this.add(panel);
    }

    public void     noCharacterSaved() {
        noCharacterSaved.setBounds(100, 30, 200, 20);
        panel.add(noCharacterSaved);
        this.add(panel);
    }

    public String   getSelectedHero()
    {
        for (Enumeration<AbstractButton> buttons = bgCharacters.getElements(); ((Enumeration<?>) buttons).hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }

    public void    addValidationButtonListener(ActionListener listenForValidationButton) {
        validationButton.addActionListener(listenForValidationButton);
    }

    public void    addMenuButtonListener(ActionListener listenForMenuButton) {
        menuButton.addActionListener(listenForMenuButton);
    }

}
