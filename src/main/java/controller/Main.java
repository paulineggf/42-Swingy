package controller;

import model.game.Game;
import model.heros.ClapTrapFactory;
import model.heros.IHero;
import model.villains.IVillain;
import model.villains.VillainsFactory;
import view.Console;
import view.IView;

import java.io.*;
import java.util.ArrayList;

public class Main
{
    // defines
    private static final int    NORTH = 8;
    private static final int    SOUTH = 2;
    private static final int    EAST = 6;
    private static final int    WEST = 4;

    private static final int    FIGHT = 1;
    private static final int    RUN = 2;


    // Attributes
    private static IView view;
    private static Game  game;


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
        view.rules();
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
        Game        newGame = new Game(hero);
        int         moveHero;
        int         villain;
        IVillain    newVillain;

        game = newGame;
        view.displayMap(game, null);
        while (true)
        {
            newVillain = null;
            moveHero = view.moveHero(game);
            if (moveHero != NORTH && moveHero != SOUTH && moveHero != WEST && moveHero != EAST)
                continue;
            game.moveHero(moveHero);
            villain = villainsRandom();
            System.out.println(villain);
            if (villain != 0)
                newVillain = VillainsFactory.newVillain(villain);
            view.displayMap(game, newVillain);
            if (villain != 0)
                launchFight(newVillain);
        }
    }

    private static int      villainsRandom()
    {
        if ((int)((Math.random() * 99) + 1) <= 33 + game.hero.getLevel())
            return (int) ((Math.random() * 3) + 1);
        return 0;
    }

    private static void     launchFight(IVillain villain) throws IOException {
        int     gamerChoice;

        gamerChoice = view.villainAppear(villain);
        if (gamerChoice == RUN)
            gamerChoice = randomFight();
        if (gamerChoice == FIGHT)
            launchBattle(villain);
    }

    private static int      randomFight() {
        int random;

        random = (int) ((Math.random() * 2) + 1);
        if (random == FIGHT)
            view.forceToFight();
        else
            view.runAway();
        return random;
    }

    private static void      launchBattle(IVillain villain) {
        while (game.hero.getHitPoints() > 0 && villain.getHitPoints() > 0)
        {
            view.heroAttack(game.hero, villain);
            game.hero.attack(villain);
            view.villainAttack(game.hero, villain);
            villain.attack(game.hero);
        }
     //   if (game.hero.getHitPoints() <= 0)
       //     view.gameOver();
    }
}
