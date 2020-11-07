package view.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuViewGui extends JFrame {
    JPanel  menuPanel = new JPanel();
    JLabel  welcomeLabel = new JLabel("Welcome to Swingy!");
    JLabel  rulesLabel = new JLabel("You win the game if you reach on of the borders of the map.");
    JButton newGameButton = new JButton("New Game");
    JButton loadGameButton = new JButton("Load Game");

    public MenuViewGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        menuPanel.setLayout(null);
        menuPanel.setBounds(400, 400, 500, 500);
        welcomeLabel.setBounds(320, 0, 200, 200);
        rulesLabel.setBounds(200, 20, 500, 200);
        newGameButton.setBounds(300, 200, 200, 50);
        loadGameButton.setBounds(300, 300, 200, 50);

        menuPanel.add(welcomeLabel);
        menuPanel.add(rulesLabel);
        menuPanel.add(newGameButton);
        menuPanel.add(loadGameButton);

        this.add(menuPanel);
    }

    public void    addNewGameButtonListener(ActionListener listenForNewGameButton) {
        newGameButton.addActionListener(listenForNewGameButton);
    }

    public void    addLoadGameButtonListener(ActionListener listenForLoadGameButton) {
        loadGameButton.addActionListener(listenForLoadGameButton);
    }
}
