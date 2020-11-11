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

    int resHeight = 900;

    public LoadGameViewGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, resHeight);
        this.setLocation(0, 0);
        panel.setLayout(null);
        panel.setBounds(400, 400, 500, resHeight);
        menuButton.setBounds(5, 5, 100, 30);
        panel.add(menuButton);
    }

    public void     displayHeros(ArrayList<GameModel> saveGames) {
        int x;
        int y;

        x = 60;
        y = 100;

        JLabel label = new JLabel(String.format("%-12s  %-12s  %-12s  %-12s  %-12s  %-12s  %-12s  %-12s  %-12s", "Name", "Type", "Level", "Experience", "Artefact", "Attack", "Defense", "Hit Points", "State"));

        chooseAHeroLabel.setBounds(x, y, 200, 20);
        label.setBounds(x + 28, (y += 50), 800, 20);
        for (GameModel saveGame: saveGames) {
            JRadioButton radioButton = new JRadioButton(String.format("%-12.10s  %-12s  %-12s  %-12s  %-12s  %-12s  %-12s  %-12s  %-12s",
                    saveGame.hero.getName(), saveGame.hero.getType(), saveGame.hero.getLevel(), saveGame.hero.getExperience(),
                    saveGame.hero.getArtefact(), saveGame.hero.getAttack(), saveGame.hero.getDefense(), saveGame.hero.getHitPoints(), saveGame.state));
            radioButton.setBounds(x + 10, (y += 30), 800, 20);
            bgCharacters.add(radioButton);
            panel.add(radioButton);
        }
        validationButton.setBounds(x + 10, y + 50, 100, 30);
        panel.add(validationButton);
        panel.add(chooseAHeroLabel);
        panel.add(label);
        this.add(panel);
    }

    public void     noCharacterSaved() {
        noCharacterSaved.setBounds(100, 50, 200, 20);
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
