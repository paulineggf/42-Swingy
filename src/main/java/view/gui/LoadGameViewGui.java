package view.gui;

import controller.GlobalVariables;
import model.game.GameModel;

import javax.swing.*;
import java.awt.*;
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
    JButton     deleteButton = new JButton("Delete");
    JButton     OKbutton = new JButton("OK");

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

        x = 5;
        y = 100;

        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);

        chooseAHeroLabel.setBounds(x, y, 200, 20);
        for (GameModel saveGame: saveGames) {
            y += 50;

            JLabel name = new JLabel("Name");
            JLabel type = new JLabel("Type");
            JLabel level = new JLabel("Level");
            JLabel experience = new JLabel("Experience");
            JLabel artefact = new JLabel("Artefact");
            JLabel attack = new JLabel("Attack");
            JLabel defense = new JLabel("Defense");
            JLabel hitPoints = new JLabel("Hit Points");
            JLabel state = new JLabel("State");

            name.setBounds(x+10, y, 100, 20);
            type.setBounds(x+10+100, y , 100, 20);
            level.setBounds(x+10+200, y , 100, 20);
            experience.setBounds(x+10+300, y, 100, 20);
            artefact.setBounds(x+10+400, y, 100, 20);


            y += 20;
            JRadioButton radioButton = new JRadioButton(String.format("%.10s", saveGame.hero.getName()));
            radioButton.setBounds(x+ 10, y, 100, 20);

            JLabel heroType = new JLabel(saveGame.hero.getType());
            JLabel heroLevel = new JLabel(Integer.toString(saveGame.hero.getLevel()));
            JLabel heroExperience = new JLabel(Float.toString(saveGame.hero.getExperience()));
            JLabel heroArtefact = new JLabel(saveGame.hero.getArtefact());
            heroType.setBounds(x+10+100, y, 100, 20);
            heroLevel.setBounds(x+10+200, y, 100, 20);
            heroExperience.setBounds(x+10+300, y, 100, 20);
            heroArtefact.setBounds(x+10+400, y, 100, 20);

            y += 30;
            attack.setBounds(x+10+100, y, 100, 20);
            defense.setBounds(x+10+200, y, 100, 20);
            hitPoints.setBounds(x+10+300, y, 100, 20);
            state.setBounds(x+10+400, y, 100, 20);

            y += 20;
            JLabel heroAttack = new JLabel(Integer.toString(saveGame.hero.getAttack()));
            JLabel heroDefense = new JLabel(Integer.toString(saveGame.hero.getDefense()));
            JLabel heroHitPoints = new JLabel(Integer.toString(saveGame.hero.getHitPoints()));

            JLabel heroState;
            if (saveGame.state == GlobalVariables.GAMEOVER)
                heroState = new JLabel("Game Over");
            else
                heroState = new JLabel("In Progress");


            heroAttack.setBounds(x+10+100, y, 100, 20);
            heroDefense.setBounds(x+10+200, y, 100, 20);
            heroHitPoints.setBounds(x+10+300, y, 100, 20);
            heroState.setBounds(x+10+400, y, 100, 20);

            bgCharacters.add(radioButton);
            panel.add(radioButton);
            panel.add(heroType);
            panel.add(heroLevel);
            panel.add(heroExperience);
            panel.add(heroArtefact);

            panel.add(attack);
            panel.add(defense);
            panel.add(hitPoints);
            panel.add(state);

            panel.add(heroAttack);
            panel.add(heroDefense);
            panel.add(heroHitPoints);
            panel.add(heroState);

            panel.add(name);
            panel.add(type);
            panel.add(level);
            panel.add(experience);
            panel.add(artefact);
        }
        validationButton.setBounds(x + 10, y + 50, 100, 30);
        deleteButton.setBounds(x+10+150, y + 50, 100, 30);
        panel.add(validationButton);
        panel.add(deleteButton);
        panel.add(chooseAHeroLabel);

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

    public void     gameOver() {
        JDialog dialog = new JDialog(this, "Game Over", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new JLabel("You can't play this game, Game over"));
        dialog.add(OKbutton);
        dialog.setSize(300, 200);
        dialog.setVisible(true);
    }

    public void    addValidationButtonListener(ActionListener listenForValidationButton) {
        validationButton.addActionListener(listenForValidationButton);
    }

    public void    addMenuButtonListener(ActionListener listenForMenuButton) {
        menuButton.addActionListener(listenForMenuButton);
    }

    public void    addDeleteButtonListener(ActionListener listenForDeleteButton) {
        deleteButton.addActionListener(listenForDeleteButton);
    }

    public void    addOKButtonListener(ActionListener listenForOKButton) {
        OKbutton.addActionListener(listenForOKButton);
    }
}
