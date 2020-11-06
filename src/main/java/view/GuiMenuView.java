package view;

import javax.swing.*;

public class GuiMenuView extends JFrame {
    JTextArea textArea = new JTextArea("Welcome to Swingy!\n" +
            "You win the game if you reach on of the borders of the map.\n");
    JButton newGameButton = new JButton("New Game");
    JButton loadGameButton = new JButton("Load Game");

    GuiMenuView() {
        JPanel menuPanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(2560, 1600);

        textArea.setBounds(500, 200, 1000, 200);
        newGameButton.setBounds(500, 500, 200, 50);
        loadGameButton.setBounds(800, 500, 200, 50);

        menuPanel.add(textArea);
        menuPanel.add(newGameButton);
        menuPanel.add(loadGameButton);

        this.add(menuPanel);
    }

    void    addNewGameButtonListener(Action listenForNewGameButton) {
        newGameButton.addActionListener(listenForNewGameButton);
    }

    void    addLoadGameButtonListener(Action listenForLoadGameButton) {
        loadGameButton.addActionListener(listenForLoadGameButton);
    }
}
