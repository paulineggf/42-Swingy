package controller;

import model.game.Game;
import model.heros.SuperHeroFactory;
import model.heros.IHero;
import model.villains.IVillain;
import model.villains.VillainsFactory;
import view.Console;
import view.Gui;
import view.IView;

import java.io.*;
import java.util.ArrayList;

public class OldMain
{
    // defines
    private static final int    NORTH = 8;
    private static final int    SOUTH = 2;
    private static final int    EAST = 6;
    private static final int    WEST = 4;

    private static final int    FIGHT = 1;
    private static final int    RUN = 2;

    private static final int    PROGRESS = 0;
    private static final int    WON = 1;
    private static final int    WONMAP = 2;
    private static final int    GAMEOVER = 3;

    private static final int    CONTINUE = 1;
    private static final int    SAVE = 2;
    private static final int    MENU = 3;
    private static final int    EXIT = 4;

    // Attributes
    private static IView view;
    private static Game  game;


    // Methods
    public static void      main(String[] args) throws Exception {

        IView chooseView = null;
        game = null;
        if (args[0].equals("console")) {
            chooseView = new Console();
        }
        else if (args[0].equals("gui")) {
            chooseView = new Gui();
        }
        else {
            System.err.println("Error argument");
            System.exit(1);
        }
        view = chooseView;
        menu();

    }

    private static void     menu() throws Exception {
        int     gamerChoice;

        gamerChoice = MENU;
        while (true)
        {
            if (gamerChoice == MENU)
            {
                gamerChoice = view.menu();
                game = heroChoice(gamerChoice);
                launchGame();
            }
            else if (gamerChoice == CONTINUE)
                launchGame();
            else if (gamerChoice == SAVE)
                saveGame();
            else if (gamerChoice == EXIT)
            {
                saveGame();
                System.exit(0);
            }
            gamerChoice = view.saveContinueMenuExit();
        }
    }

    private static void     saveGame()
    {
        try {
            ResourceManager.save((Serializable) game, "./src/main/data/save");
            view.wellSaved();
        }
        catch (Exception e) {
            System.err.println("Couldn't load save data " + e.getMessage());
        }
    }

    private static Game    heroChoice(int gamerChoice) throws Exception {
        IHero   hero;

        if (gamerChoice == 1)
            return newGame();
        if (gamerChoice == 2)
            return loadGame();
        return null;
    }

    private static Game    newGame() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String  type;
        String  artefact;
        String  name;
        IHero   hero;

        type = view.chooseSuperHero();
        artefact = view.chooseArtefact();
        name = view.chooseName();
        hero = SuperHeroFactory.newClapTrap(type, name, artefact);
        return new Game(hero);
    }

    private static Game    loadGame() throws Exception {
        try {
            String name;
            ArrayList<Game> saveGames = new ArrayList<Game>();
            saveGames = (ArrayList<Game>)ResourceManager.load("./src/main/data/save");
            if (saveGames != null) {
                name = view.displayCharacters(saveGames);
                for (Game saveGame: saveGames) {
                    if (name.equals(saveGame.hero.getName()) && saveGame.game == GAMEOVER)
                    {
                        view.characterGameOver();
                        return null;
                    }
                    else if (name.equals(saveGame.hero.getName()))
                        return saveGame;
                }
            }
            else
                view.noCharacterSaved();
        }
        catch (Exception e) {
            System.err.println("Couldn't load save data: " + e.getMessage());
        }
        return null;
    }

    private static void     launchGame() throws IOException {
        int         moveHero;
        int         villain;
        IVillain    newVillain;

        newVillain = null;
        game.resetMap();
        view.displayMap(game, null);
        game.game = PROGRESS;
        while (game.game == PROGRESS) {
            if (newVillain != null) {
                view.displayMap(game, newVillain);
            }
            newVillain = null;
            moveHero = view.moveHero(game);
            if (moveHero != NORTH && moveHero != SOUTH && moveHero != WEST && moveHero != EAST) {
                continue;
            }
            game.moveHero(moveHero);
            villain = villainsRandom();
            System.out.println(villain);
            if (villain != 0) {
                newVillain = VillainsFactory.newVillain(villain);
            }
            view.displayMap(game, newVillain);
            if (villain != 0) {
                launchFight(newVillain);
            }
            if (game.game != GAMEOVER)
                resultsFight(newVillain);
        }
        resultGame();
    }

    private static void     launchFight(IVillain villain) throws IOException {
        int     gamerChoice;

        gamerChoice = view.villainAppear(villain);
        if (gamerChoice == RUN)
            gamerChoice = randomFight();
        if (gamerChoice == FIGHT)
            launchBattle(villain);
    }

    private static void      launchBattle(IVillain villain) throws IOException {
        int     gamerChoice;

        while (true)
        {
            view.heroAttack(game.hero, villain);
            game.hero.attack(villain);
            view.getHitPoints(game.hero, villain);
            if (villain.getHitPoints() <= 0)
                break;
            view.villainAttack(game.hero, villain);
            villain.attack(game.hero);
            view.getHitPoints(game.hero, villain);
            if (game.hero.getHitPoints() <= 0)
                break;
            gamerChoice = view.continueToFightOrRun();
            if (gamerChoice == RUN)
                gamerChoice = randomFight();
            if (gamerChoice == RUN)
            {
                view.runAway();
                break;
            }
            else
                view.forceToFight();
        }
        if (game.hero.getHitPoints() <= 0)
        {
            view.gameOver(game.hero);
            game.game = GAMEOVER;
        }
        else if (game.experienceUp(villain) == true) {
            view.levelUp(game.hero);
        }
    }

    private static void     resultsFight(IVillain villain)
    {
        if (isEscape()) {
            game.experienceUp(null);
            view.wonMap(game.hero);
            game.game = WONMAP;
        }
    }

    private static void     resultGame()
    {
        if (game.hero.getLevel() == 5 && game.game != GAMEOVER)
        {
            view.won(game.hero);
            game.game = WON;
        }
    }

    private static boolean  isEscape()
    {
        if (game.pos.getX() == 0 || game.pos.getX() + 1 == game.map.getX()
                || game.pos.getY() == 0 || game.pos.getY() + 1 == game.map.getY())
            return true;
        return false;
    }

    private static int      villainsRandom()
    {
        if ((int)((Math.random() * 99) + 1) <= 33 + (game.hero.getLevel() * 2))
            return (int) ((Math.random() * 3) + 1);
        return 0;
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
}
