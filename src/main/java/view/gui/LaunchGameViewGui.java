package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LaunchGameViewGui extends JFrame {
    JPanel      panel = new JPanel();
    JPanel      gamePanel = new JPanel();
    public JFrame      directional = new JFrame();
    JButton     northButton = new JButton("North");
    JButton     southButton = new JButton("South");
    JButton     eastButton = new JButton("East");
    JButton     westButton = new JButton("West");

    public LaunchGameViewGui(int heroX, int heroY, int mapX, int mapY, char initial) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        directional.setSize(400, 200);
        panel.setLayout(null);
        panel.setBounds(400, 400, 500, 500);
        northButton.setBounds(100, 0, 200, 50);
        eastButton.setBounds(200, 50, 200, 50);
        westButton.setBounds(0, 50, 200, 50);
        southButton.setBounds(100, 100, 200, 50);
        panel.add(northButton);
        panel.add(eastButton);
        panel.add(westButton);
        panel.add(southButton);
        directional.add(panel);
        directional.setVisible(true);

        for (int i = 0; i < mapY; i++)
        {
            for (int j = 0; j < mapX; j++)
            {
                JButton button;
                if (heroY == i && heroX == j)
                    button = new JButton(String.format("H%c", initial));
                else
                    button = new JButton("");
                gamePanel.add(button);
            }
        }
        gamePanel.setLayout(new GridLayout(mapX, mapY));
        this.add(gamePanel);
    }

    public void    addNorthButtonListener(ActionListener listenForNorthButton) {
        northButton.addActionListener(listenForNorthButton);
    }

    public void    addSouthButtonListener(ActionListener listenForSouthButton) {
        southButton.addActionListener(listenForSouthButton);
    }

    public void    addEastButtonListener(ActionListener listenForEastButton) {
        eastButton.addActionListener(listenForEastButton);
    }

    public void    addWestButtonListener(ActionListener listenForWestButton) {
        westButton.addActionListener(listenForWestButton);
    }

}
