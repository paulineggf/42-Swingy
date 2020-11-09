package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LaunchGameViewGui extends JFrame {
    JPanel  panel = new JPanel();
    JPanel  gamePanel = new JPanel();
    JPanel  fightPanel = new JPanel();
    JFrame  directional = new JFrame();
    JFrame  fightFrame = new JFrame();
    JButton northButton = new JButton("North");
    JButton southButton = new JButton("South");
    JButton eastButton = new JButton("East");
    JButton westButton = new JButton("West");
    JButton runButton = new JButton("Run");
    JButton fightButton = new JButton("Fight");
    int y = 30;

    public LaunchGameViewGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLocation(400, 0);
        directional.setSize(400, 180);
        directional.setLocation(0, 0);
        fightFrame.setSize(500, 800);
        fightFrame.setLocation(1200, 0);
        panel.setLayout(null);
        panel.setBounds(400, 400, 500, 500);
        fightPanel.setBounds(1200, 0, 500, 800);
        northButton.setBounds(100, 0, 200, 50);
        eastButton.setBounds(200, 50, 200, 50);
        westButton.setBounds(0, 50, 200, 50);
        southButton.setBounds(100, 100, 200, 50);
        runButton.setBounds(20, 50, 200, 50);
        runButton.setEnabled(false);
        fightButton.setBounds(120, 50, 200, 50);
        fightButton.setEnabled(false);
        panel.add(northButton);
        panel.add(eastButton);
        panel.add(westButton);
        panel.add(southButton);
        fightPanel.add(runButton);
        fightPanel.add(fightButton);
        directional.add(panel);
        fightFrame.add(fightPanel);
        directional.setVisible(true);
        fightFrame.setVisible(true);
        this.setVisible(true);
    }

    public void    newMap(int heroX, int heroY, int mapX, int mapY, char initial)
    {
        Component[] components = gamePanel.getComponents();

        for (Component component : components) {
            gamePanel.remove(component);
        }
        gamePanel.revalidate();
        gamePanel.repaint();
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

    public void    fight(String heroName, String villainType)
    {
        fightPanel.revalidate();
        fightPanel.repaint();
        fightPanel.setLayout(null);
        JLabel label = new JLabel("A " + villainType + " appeared!");
        JLabel label1 = new JLabel("Would you like to fight or run?");
        label.setBounds(20, y += 20, 800, 20);
        label1.setBounds(20, y += 20, 800, 20);
        runButton.setEnabled(true);
        fightButton.setEnabled(true);
        northButton.setEnabled(false);
        southButton.setEnabled(false);
        westButton.setEnabled(false);
        eastButton.setEnabled(false);
        fightPanel.add(label);
        fightPanel.add(label1);
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
