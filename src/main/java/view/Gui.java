package view;

import model.game.GameModel;
import model.heros.IHero;
import model.villains.IVillain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Gui implements IView {

    private static final int    NEWGAME = 1;
    private static final int    LOADGAME = 2;

    JFrame frame;

    public Gui()
    {
        frame = new JFrame();

    }

    public int     menu() throws IOException
    {

        JTextArea textArea = new JTextArea("Welcome to Swingy!\n" +
                "You win the game if you reach on of the borders of the map.\n");
        JButton newGame = new JButton("New Game");
        JButton loadGame = new JButton("Load Game");

        textArea.setBounds(500, 200, 1000, 200);
        newGame.setBounds(500, 500, 200, 50);
        loadGame.setBounds(800, 500, 200, 50);



        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                byte[] byteArray = new byte[2];
                byteArray[0] = '1';
                try (InputStream fakeIn = new ByteArrayInputStream(byteArray)) {
                    System.setIn(fakeIn);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        loadGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println(LOADGAME);
            }
        });

        frame.add(textArea);
        frame.add(newGame);
        frame.add(loadGame);
        frame.setSize(2560, 1600);
        frame.setLayout(null);
        frame.setVisible(true);

        return 0;
    }


    public void     wellSaved() {
    }

    public String   chooseSuperHero() throws IOException { return "";}

    public String   chooseArtefact() throws IOException {
        return "";
    }

    public String   chooseName() throws IOException {
        return "";
    }

    public String     displayCharacters(ArrayList<GameModel> saveGames) throws IOException {
        return "";
    }

    public void     noCharacterSaved()
    {
        return;
    }

    public void     characterGameOver()
    {
        return;
    }

    public void     displayMap(GameModel game, IVillain villain)
    {
        return;
    }

    public int      moveHero(GameModel game) throws IOException {
        return 0;
    }

    public int       villainAppear(IVillain villain) throws IOException {
        return 0;
    }

    public void     forceToFight()
    {
        return;
    }

    public void     runAway()
    {
        return;
    }

    public void     heroAttack(IHero hero, IVillain villain)
    {
        return;
    }

    public void     villainAttack(IHero hero, IVillain villain)
    {
        return;
    }

    public void     getHitPoints(IHero hero, IVillain villain)
    {
        return;
    }

    public int      continueToFightOrRun() throws IOException {
        return 0;
    }

    public void     gameOver(IHero hero)
    {

    }

    public void     levelUp(IHero hero)
    {

    }

    public void     wonMap(IHero hero)
    {
    }

    public int      saveContinueMenuExit() throws IOException {
        return 0;
    }

    public void     won(IHero hero)
    {
    }
}
