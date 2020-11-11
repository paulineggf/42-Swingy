package view.gui;

import controller.GlobalVariables;

import javax.swing.*;
import java.awt.event.ActionListener;

public class EndOfGameViewGui extends JFrame {
    JPanel  panel = new JPanel();
    JButton continueButton = new JButton("Continue");
    JButton menuButton = new JButton("Menu");

    int resHeight = 900;

    public EndOfGameViewGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, resHeight);
        this.setLocation(0, 0);
        panel.setLayout(null);
        panel.setBounds(400, 400, 500, resHeight);
        continueButton.setBounds(150, 200, 200, 50);
        menuButton.setBounds(150, 300, 200, 50);


        panel.add(continueButton);
        panel.add(menuButton);

        this.add(panel);
    }

    public void     visible(int state)
    {
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);

        JLabel label;
        if (state == GlobalVariables.GAMEOVER)
        {
            label = new JLabel("GAME OVER :(");
            continueButton.setEnabled(false);
        }
        else
            label = new JLabel("Well Done! You won!");

        label.setBounds(180, 0, 200, 200);
        panel.add(label);


    }

    public void     addContinueButtonListener(ActionListener listenForContinueButton) {
        continueButton.addActionListener(listenForContinueButton);
    }

    public void    addMenuButtonListener(ActionListener listenForMenuButton) {
        menuButton.addActionListener(listenForMenuButton);
    }
}
