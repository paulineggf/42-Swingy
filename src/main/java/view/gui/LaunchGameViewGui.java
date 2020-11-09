package view.gui;

import javax.swing.*;

public class LaunchGameViewGui extends JFrame {
    JPanel      panel = new JPanel();
    JButton     northButton = new JButton("North");
    JButton     southButton = new JButton("South");
    JButton     eastButton = new JButton("East");
    JButton     westButton = new JButton("West");

    public LaunchGameViewGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        panel.setLayout(null);
        panel.setBounds(400, 400, 500, 500);
        northButton.setBounds(500, 100, 100, 30);
        eastButton.setBounds(400, 200, 100, 30);
        westButton.setBounds(600, 200, 100, 30);
        southButton.setBounds(500, 100, 100, 30);
        panel.add(northButton);
        panel.add(eastButton);
        panel.add(westButton);
        panel.add(southButton);


    }
}
