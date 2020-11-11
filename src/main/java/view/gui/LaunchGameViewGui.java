package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class LaunchGameViewGui extends JFrame {
    JPanel  panel = new JPanel();
    JPanel  gamePanel = new JPanel();
    public JFrame  directionalFrame = new JFrame();
    JButton northButton = new JButton("North");
    JButton southButton = new JButton("South");
    JButton eastButton = new JButton("East");
    JButton westButton = new JButton("West");
    JButton runButton = new JButton("Run");
    JButton fightButton = new JButton("Fight");
    JButton continueButton = new JButton("Continue");
    JButton menuButton = new JButton("Menu");


    int y = 230;
    int resHeight = 900;

    public LaunchGameViewGui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, resHeight);
        this.setLocation(500, 0);
        directionalFrame.setSize(500, resHeight);
        directionalFrame.setLocation(0, 0);
        panel.setLayout(null);
        panel.setBounds(400, 400, 500, resHeight);
        northButton.setBounds(150, 0, 200, 50);
        eastButton.setBounds(250, 50, 200, 50);
        westButton.setBounds(50, 50, 200, 50);
        southButton.setBounds(150, 100, 200, 50);
        runButton.setBounds(20, 200, 100, 30);
        runButton.setEnabled(false);
        fightButton.setBounds(120, 200, 100, 30);
        fightButton.setEnabled(false);
        continueButton.setBounds(250, 200, 100, 30);
        menuButton.setBounds(350, 200, 100, 30);
        continueButton.setEnabled(false);
        menuButton.setEnabled(false);
        panel.add(northButton);
        panel.add(eastButton);
        panel.add(westButton);
        panel.add(southButton);
        panel.add(runButton);
        panel.add(fightButton);
        panel.add(continueButton);
        panel.add(menuButton);
        directionalFrame.add(panel);
        directionalFrame.setVisible(true);
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

    private void     cleanComponents()
    {
        Component[] components = panel.getComponents();

        for (Component component : components) {
            if (component != runButton && component != fightButton
                && component != westButton && component != eastButton
                && component != northButton && component != southButton)
                panel.remove(component);
        }
    }

    public void    fight(String heroName, String villainType)
    {
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);
        JLabel label = new JLabel("A " + villainType + " appeared!");
        JLabel label1 = new JLabel("Would you like to fight or run?");
        JLabel label2 = new JLabel("");
        if (y + 40 > resHeight - 50)
        {
            y = 230;
            cleanComponents();
        }
        label.setBounds(20, y += 20, 800, 20);
        label1.setBounds(20, y += 20, 800, 20);
        label2.setBounds(20, y += 20, 800, 20);
        enableRunAndFightButtons();
        disabledirectionalFramesButtons();
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
    }

    public void     otherChanceToRunAway() {
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);
        JLabel label = new JLabel("You have an other chance to run away!");
        JLabel label1 = new JLabel("");
        if (y + 20 > resHeight - 50)
        {
            y = 230;
            cleanComponents();
        }
        label.setBounds(20, y += 20, 800, 20);
        label1.setBounds(20, y += 20, 800, 20);
        enableRunAndFightButtons();
        disabledirectionalFramesButtons();
        panel.add(label);
        panel.add(label1);
    }

    public void     heroAttack(String heroName, String villainType, int heroAttack) {
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);
        JLabel label = new JLabel(heroName + " attack the " + villainType + "!");
        JLabel label1 = new JLabel("The " + villainType + " loose " + heroAttack + " hit points.");
        JLabel label2 = new JLabel("");
        if (y + 40 > resHeight - 50)
        {
            y = 230;
            cleanComponents();
        }
        label.setBounds(20, y += 20, 800, 20);
        label1.setBounds(20, y += 20, 800, 20);
        label2.setBounds(20, y += 20, 800, 20);
        disabledirectionalFramesButtons();
        disableRunAndFightButtons();
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
    }

    public  void    getHitPoints(String heroName, String villainType, int heroHitPoints, int villainHitPoints)
    {
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);
        JLabel label = new JLabel(heroName+ " hit points: " + heroHitPoints);
        JLabel label1 = new JLabel(villainType + " hit points: " + villainHitPoints);
        JLabel label2 = new JLabel("");
        if (y + 40 > resHeight - 50)
        {
            y = 230;
            cleanComponents();
        }
        label.setBounds(20, y += 20, 800, 20);
        label1.setBounds(20, y += 20, 800, 20);
        label2.setBounds(20, y += 20, 800, 20);
        disabledirectionalFramesButtons();
        disableRunAndFightButtons();
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
    }

    public void     levelUp(boolean levelUp, String heroName, int heroLevel)
    {
        if (levelUp)
        {
            panel.revalidate();
            panel.repaint();
            panel.setLayout(null);
            JLabel label = new JLabel(heroName + " is level up to level " + heroLevel + "!");
            JLabel label1 = new JLabel("");
            if (y + 20 > resHeight - 50)
            {
                y = 230;
                cleanComponents();
            }
            label.setBounds(20, y += 20, 800, 20);
            label1.setBounds(20, y += 20, 800, 20);
            panel.add(label);
            panel.add(label1);
        }
        enabledirectionalFramesButtons();
        disableRunAndFightButtons();
    }

    public void     villainAttack(String heroName, String villainType, int villainAttack, int heroDefense)
    {
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);
        JLabel label = new JLabel("The " + villainType + " attack " + heroName + "!");
        JLabel label1 = new JLabel(heroName + " loose " + (villainAttack - heroDefense) + " hit points.");
        JLabel label2 = new JLabel("");
        if (y + 40 > resHeight - 50)
        {
            y = 230;
            cleanComponents();
        }
        label.setBounds(20, y += 20, 800, 20);
        label1.setBounds(20, y += 20, 800, 20);
        label2.setBounds(20, y += 20, 800, 20);
        disabledirectionalFramesButtons();
        disableRunAndFightButtons();
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
    }

    private void    disabledirectionalFramesButtons()
    {
        northButton.setEnabled(false);
        southButton.setEnabled(false);
        westButton.setEnabled(false);
        eastButton.setEnabled(false);
    }

    private void    disableRunAndFightButtons() {
        runButton.setEnabled(false);
        fightButton.setEnabled(false);
    }

    private void    enabledirectionalFramesButtons()
    {
        northButton.setEnabled(true);
        southButton.setEnabled(true);
        westButton.setEnabled(true);
        eastButton.setEnabled(true);
    }

    private void    enableRunAndFightButtons() {
        runButton.setEnabled(true);
        fightButton.setEnabled(true);
    }

    public void     forceToFight()
    {
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);
        JLabel label = new JLabel("You can't run! You have to fight!!");
        if (y + 20 > 750)
        {
            y = 230;
            cleanComponents();
        }
        label.setBounds(20, y += 20, 800, 20);
        disableRunAndFightButtons();
        panel.add(label);
    }

    public void     runAway()
    {
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);
        JLabel label = new JLabel("You managed to escape!!");
        JLabel label1= new JLabel("");
        if (y + 20 > 750)
        {
            y = 230;
            cleanComponents();
        }
        label.setBounds(20, y += 20, 800, 20);
        label1.setBounds(20, y += 20, 800, 20);
        disableRunAndFightButtons();
        enabledirectionalFramesButtons();
        panel.add(label);
        panel.add(label1);
    }

    public void     escape()
    {
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);
        cleanComponents();
        disableRunAndFightButtons();
        disabledirectionalFramesButtons();
        JLabel label = new JLabel("Well done! You won!");
        label.setBounds(250, 180, 800, 20);
        continueButton.setEnabled(true);
        menuButton.setEnabled(true);
        panel.add(label);
        panel.add(continueButton);
        panel.add(menuButton);
    }

    public void     gameOver()
    {
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);
        //cleanComponents();
        disableRunAndFightButtons();
        disabledirectionalFramesButtons();
        JLabel label = new JLabel("Game over :(");
        label.setBounds(250, 180, 800, 20);
        continueButton.setEnabled(false);
        menuButton.setEnabled(true);
        panel.add(label);
        panel.add(continueButton);
        panel.add(menuButton);
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

    public void    addRunButtonListener(ActionListener listenForRunButton) {
        runButton.addActionListener(listenForRunButton);
    }

    public void    addFightButtonListener(ActionListener listenForFightButton) {
        fightButton.addActionListener(listenForFightButton);
    }

    public void    addContinueButtonListener(ActionListener listenForContinueButton) {
        continueButton.addActionListener(listenForContinueButton);
    }

    public void    addMenuButtonListener(ActionListener listenForMenuButton) {
        menuButton.addActionListener(listenForMenuButton);
    }
}
