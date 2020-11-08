package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class NewGameViewGui extends JFrame {
    JPanel          newGamePanel = new JPanel();
    JLabel          chooseAHeroLabel = new JLabel("Choose a Hero:");
    JRadioButton    spidermanRadioButton = new JRadioButton("Spiderman");
    JRadioButton    supermanRadioButton = new JRadioButton("Superman");
    JRadioButton    elasticmanRadioButton = new JRadioButton("Elasticman");
    ButtonGroup     bgHero = new ButtonGroup();
    JLabel          chooseAnArtefactLabel = new JLabel("Choose an artefact:");
    JRadioButton    weaponRadioButton = new JRadioButton("Weapon +20 attack");
    JRadioButton    armorRadioButton = new JRadioButton("Armor +20 defense");
    JRadioButton    helmRadioButton = new JRadioButton("Helm +20 hit points");
    ButtonGroup     bgArtefact = new ButtonGroup();
    JLabel          chooseANameLabel = new JLabel("Choose a name:");
    JTextField      nameTextField = new JTextField();
    JButton         validationButton = new JButton("OK");

    public NewGameViewGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        newGamePanel.setLayout(null);
        newGamePanel.setBounds(400, 400, 500, 500);

        chooseAHeroLabel.setBounds(100, 50, 200, 10);
        spidermanRadioButton.setBounds(100, 70, 200, 20);
        supermanRadioButton.setBounds(100, 90, 200, 20);
        elasticmanRadioButton.setBounds(100, 110, 200, 20);
        bgHero.add(spidermanRadioButton);
        bgHero.add(supermanRadioButton);
        bgHero.add(elasticmanRadioButton);

        chooseAnArtefactLabel.setBounds(100, 180, 200, 10);
        weaponRadioButton.setBounds(100, 200, 200, 20);
        armorRadioButton.setBounds(100, 220, 200, 20);
        helmRadioButton.setBounds(100, 240, 200, 20);
        bgArtefact.add(weaponRadioButton);
        bgArtefact.add(armorRadioButton);
        bgArtefact.add(helmRadioButton);

        chooseANameLabel.setBounds(100, 310, 200, 10);
        nameTextField.setBounds(100, 330, 200, 20);

        validationButton.setBounds(100, 380, 100, 30);

        newGamePanel.add(chooseAHeroLabel);
        newGamePanel.add(spidermanRadioButton);
        newGamePanel.add(supermanRadioButton);
        newGamePanel.add(elasticmanRadioButton);
        newGamePanel.add(chooseAnArtefactLabel);
        newGamePanel.add(weaponRadioButton);
        newGamePanel.add(armorRadioButton);
        newGamePanel.add(helmRadioButton);
        newGamePanel.add(chooseANameLabel);
        newGamePanel.add(nameTextField);
        newGamePanel.add(validationButton);

        this.add(newGamePanel);
    }

    public void     addValidationButtonListener(ActionListener listenForValidationButton) {
        validationButton.addActionListener(listenForValidationButton);
    }

    public String   getSelectedHero()
    {
        for (Enumeration<AbstractButton> buttons = bgHero.getElements(); ((Enumeration<?>) buttons).hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }

    public String   getSelectedArtefact()
    {
        for (Enumeration<AbstractButton> buttons = bgArtefact.getElements(); ((Enumeration<?>) buttons).hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }

    public boolean  getSpidermanRadioButton()
    {

        return spidermanRadioButton.isSelected();
    }

    public boolean  getSupermanRadioButton()
    {
        return supermanRadioButton.isSelected();
    }

    public boolean  getElasticmanRadioButton()
    {
        return elasticmanRadioButton.isSelected();
    }

    public boolean  getWeaponRadioButton()
    {
        return weaponRadioButton.isSelected();
    }

    public boolean  getArmorRadioButton()
    {
        return armorRadioButton.isSelected();
    }

    public boolean  getHelmRadioButton()
    {
        return helmRadioButton.isSelected();
    }

    public String   getName()
    {
        return nameTextField.getText();
    }
}

