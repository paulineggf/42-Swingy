package view.gui;

import javax.swing.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class NewGameViewGui extends JFrame {
    JPanel          panel = new JPanel();
    JLabel          chooseAHeroLabel = new JLabel("Choose a SuperHero:");
    JRadioButton    spidermanRadioButton = new JRadioButton("Spiderman +30 attack, +10 defense, +100 hit points");
    JRadioButton    supermanRadioButton = new JRadioButton("Superman +20 attack, +20 defense, +100 hit points");
    JRadioButton    elasticmanRadioButton = new JRadioButton("Elasticman +60 attack, +20 defense, +60 hit points");
    ButtonGroup     bgHero = new ButtonGroup();
    JLabel          chooseAnArtefactLabel = new JLabel("Choose an artefact:");
    JRadioButton    weaponRadioButton = new JRadioButton("Weapon +20 attack");
    JRadioButton    armorRadioButton = new JRadioButton("Armor +20 defense");
    JRadioButton    helmRadioButton = new JRadioButton("Helm +20 hit points");
    ButtonGroup     bgArtefact = new ButtonGroup();
    JLabel          chooseANameLabel = new JLabel("Choose a name:");
    JTextField      nameTextField = new JTextField();
    JButton         validationButton = new JButton("OK");
    JButton         menuButton = new JButton("Menu");
    JLabel          tooManySavedGame = new JLabel("You have too many saved game.");
    JLabel          tooManySavedGame2 = new JLabel(" Delete before created a new one (5 maximum).");

    int resHeight = 900;

    public NewGameViewGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, resHeight);
        this.setLocation(0, 0);

        panel.setLayout(null);
        panel.setBounds(400, 400, 500, resHeight);
        menuButton.setBounds(5, 5, 100, 30);
        panel.add(menuButton);

    }

    public void     newGame() {
        int x;
        int y;

        x = 80;
        y = 100;
        chooseAHeroLabel.setBounds(x, y, 200, 10);
        spidermanRadioButton.setBounds(x, (y += 20), 800, 20);
        supermanRadioButton.setBounds(x, (y += 20), 800, 20);
        elasticmanRadioButton.setBounds(x, (y += 20), 800, 20);
        bgHero.add(spidermanRadioButton);
        bgHero.add(supermanRadioButton);
        bgHero.add(elasticmanRadioButton);

        chooseAnArtefactLabel.setBounds(x, (y += 70), 200, 10);
        weaponRadioButton.setBounds(x, (y += 20), 200, 20);
        armorRadioButton.setBounds(x, (y += 20), 200, 20);
        helmRadioButton.setBounds(x, (y += 20), 200, 20);
        bgArtefact.add(weaponRadioButton);
        bgArtefact.add(armorRadioButton);
        bgArtefact.add(helmRadioButton);

        chooseANameLabel.setBounds(x, (y += 70), 200, 10);
        nameTextField.setBounds(x, (y += 20), 200, 20);

        validationButton.setBounds(x, (y += 30), 100, 30);

        panel.add(chooseAHeroLabel);
        panel.add(spidermanRadioButton);
        panel.add(supermanRadioButton);
        panel.add(elasticmanRadioButton);
        panel.add(chooseAnArtefactLabel);
        panel.add(weaponRadioButton);
        panel.add(armorRadioButton);
        panel.add(helmRadioButton);
        panel.add(chooseANameLabel);
        panel.add(nameTextField);
        panel.add(validationButton);

        this.add(panel);
        this.setVisible(true);
    }

    public void     tooManySavedGame() {
        tooManySavedGame.setBounds(20, 100, 800, 20);
        tooManySavedGame2.setBounds(20, 130, 800, 20);
        panel.add(tooManySavedGame);
        panel.add(tooManySavedGame2);
        this.add(panel);
        this.setVisible(true);
    }

    public void     addValidationButtonListener(ActionListener listenForValidationButton) {
        validationButton.addActionListener(listenForValidationButton);
    }

    public void    addMenuButtonListener(ActionListener listenForMenuButton) {
        menuButton.addActionListener(listenForMenuButton);
    }

    public String   getSelectedHero()
    {
        for (Enumeration<AbstractButton> buttons = bgHero.getElements(); ((Enumeration<?>) buttons).hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText().split(" ")[0];
            }
        }
        return "";
    }

    public String   getSelectedArtefact()
    {
        for (Enumeration<AbstractButton> buttons = bgArtefact.getElements(); ((Enumeration<?>) buttons).hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText().split(" ")[0];
            }
        }
        return "";
    }

    public String   getName()
    {
        return nameTextField.getText();
    }
}

