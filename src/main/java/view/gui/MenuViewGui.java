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

    int resHeight = 900;

    public MenuViewGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, resHeight);
        this.setLocation(0, 0);
        menuPanel.setLayout(null);
        menuPanel.setBounds(400, 400, 500, resHeight);
        welcomeLabel.setBounds(180, 0, 200, 200);
        rulesLabel.setBounds(50, 20, 500, 200);
        newGameButton.setBounds(150, 200, 200, 50);
        loadGameButton.setBounds(150, 300, 200, 50);

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
