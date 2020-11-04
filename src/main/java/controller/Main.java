package controller;

import model.game.Game;
import model.heros.ClapTrapFactory;
import model.heros.IHero;
import view.Console;
import view.IView;

import java.io.*;
import java.util.ArrayList;

public class Main
{
    // Attributes
    private static IView view;

    // Methods
    public static void      main(String[] args) throws Exception {
        int gamerChoice;

        IView chooseView = null;
        if (args[0].equals("console")) {
            chooseView = new Console();
        }
        else if (args[0].equals("gui")) {
            return;
        }
        else {
            System.err.println("Error argument");
            System.exit(1);
        }
        view = chooseView;
        gamerChoice = view.init();
        IHero hero = heroChoice(gamerChoice);
        launchGame(hero);
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
        String  type;
        String  artefact;
        String  name;
        IHero   hero;

        type = view.chooseClapTrap();
        artefact = view.chooseArtefact();
        name = view.chooseName();
        hero = ClapTrapFactory.newClapTrap(type, name, artefact);

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
                name = view.displayCharacters(heroSave);
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

    private static void     launchGame(IHero hero) throws IOException {
        Game    game = new Game(hero);
        int     moveHero;

        while (true)
        {
            view.displayMap(game);
            moveHero = view.moveHero(game);
            game.moveHero(moveHero);
            view.displayMap(game);
        }
    }
}
