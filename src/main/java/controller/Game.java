package controller;

import heros.ClapTrapFactory;
import heros.IHero;
import view.Console;
import view.IView;

import java.io.*;
import java.util.ArrayList;

public class Game
{
    // Attributes
    private static IView game;

    public static void      main(String[] args) throws Exception {
        int gamerChoice;

        IView g = null;
        if (args[0].equals("console")) {
            g = new Console();
        }
        else if (args[0].equals("gui")) {
            return;
        }
        else {
            System.err.println("Error argument");
            System.exit(1);
        }
        game = g;
        gamerChoice = game.init();
        IHero hero = heroChoice(gamerChoice);
    }

    private static IHero     heroChoice(int gamerChoice) throws Exception {
        IHero   hero;

        if (gamerChoice == 1)
            return newGame();
        if (gamerChoice == 2)
            return loadGame();
        return null;
    }

    private static IHero    newGame() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String type;
        String artefact;
        String name;
        ClapTrapFactory clapTrapFactory = new ClapTrapFactory();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        IHero hero;

        type = game.chooseClapTrap();
        artefact = game.chooseArtefact();
        name = game.chooseName();
        hero = clapTrapFactory.newClapTrap(type, name, artefact);

        // Save data
        try {
            ResourceManager.save((Serializable) hero, "./src/main/data/save");
        }
        catch (Exception e) {
            System.err.println("Couldn't load save data " + e.getMessage());
        }
        return hero;
    }

    private static IHero    loadGame() throws Exception {
        try {
            String name;
            ArrayList<IHero> heroSave = new ArrayList<IHero>();
            heroSave = (ArrayList<IHero>)ResourceManager.load("./src/main/data/save");
            if (heroSave != null) {
                name = game.displayCharacters(heroSave);
                for (IHero hero: heroSave) {
                    if (name.equals(hero.getName()))
                        return hero;
                }
            }
            else
                System.out.println("No character saved");
        }
        catch (Exception e) {
            System.err.println("Couldn't load save data: " + e.getMessage());
        }
        return null;
    }



    private static void     launchGame(IHero hero)
    {

    }
}
