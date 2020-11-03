package game;

import heros.ClapTrapFactory;
import heros.IClapTrap;
import heros.IHero;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Game
{
    public static void  main(String[] args) throws Exception {
        int gamerChoice;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            gamerChoice = 0;
            IHero hero;
            while (gamerChoice != 1 && gamerChoice != 2)
            {
                System.out.println("Gamer choice: " + gamerChoice);
                System.out.println("Welcome to Swingy!");
                System.out.println("1. New game");
                System.out.println("2. Load save game");
                gamerChoice = Integer.parseInt(br.readLine());
                if (gamerChoice == 1)
                    hero = newGame();
                else if (gamerChoice == 2)
                    hero = loadGames();
                else
                    System.out.println("Please try again");
            }
            //launchGame(hero);
        }
        catch (IOException ioe)
        {
            System.err.println(ioe);
        }
    }

    private static IHero    newGame() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        String type;
        String artefact;
        String name;
        ClapTrapFactory clapTrapFactory = new ClapTrapFactory();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        IHero hero;

        try
        {
            System.out.println("Choose a ClapTrap");
            System.out.println("Type      " + " attack " + " defense " + " hit points ");
            System.out.println("FragTrap  " + " 30     " + " 10      " + " 100        ");
            System.out.println("ScavTrap  " + " 20     " + " 20      " + " 100        ");
            System.out.println("NinjaTrap " + " 60     " + " 30      " + " 60         ");

            type = null;
            while (true)
            {
                type = br.readLine();
                if (type.equals("FragTrap") || type.equals("ScavTrap") || type.equals("NinjaTrap"))
                    break;
                System.out.println("Please try again");
            }

            System.out.println("Choose an artefact");
            System.out.println("             " + " attack " + " defense " + " hit points ");
            System.out.println("1. Weapon    " + " +20    " + " 0       " + " 0          ");
            System.out.println("2. Armor     " + " 0      " + " +20     " + " 0          ");
            System.out.println("3. Helm      " + " 0      " + " 0       " + " +20        ");

            artefact = null;
            while (true)
            {
                artefact = br.readLine();
                if (artefact.equals("Weapon") || artefact.equals("Armor") || artefact.equals("Helm"))
                    break;
                System.out.println("Please try again");
            }

            System.out.println("Choose a name for your hero");
            name = br.readLine();

            hero = clapTrapFactory.newClapTrap(type, name, artefact);
            try {
                ResourceManager.save((Serializable) hero, "save");
            }
            catch (Exception e) {
                System.err.println("1/ Couldn't load save data " + e.getMessage());
            }
            return hero;

        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
        return null;
    }

    private static IHero    loadGames() throws Exception {
        try {
            ArrayList<IHero> heroSave = new ArrayList<IHero>();
            heroSave = (ArrayList<IHero>)ResourceManager.load("save");
            if (heroSave != null) {
                displayCharacters(heroSave);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    String name = br.readLine();
                    for (IHero hero : heroSave) {
                        if (name.equals(hero.getName()))
                            return hero;
                    }
                    System.out.println("Don't know this character, please try again");
                }
            }
            else
            {
                System.out.println("No character saved");
            }
        }
        catch (Exception e) {
            System.err.println("2/ Couldn't load save data: " + e.getMessage());
        }
        return null;
    }

    private static void     displayCharacters(ArrayList<IHero> heroSave)
    {
        System.out.println("Choose a ClapTrap");
        for (IHero hero: heroSave) {
            System.out.println("Name      " + " type    " + " level " + " experience " + "Weapon   " + " attack " + " defense " + " hit points ");
            System.out.println(hero.getName() + " " + hero.getType() + " " + hero.getLevel() + " " + hero.getExperience() + " " + hero.getArtefact() + " " + hero.getAttack() + " " + hero.getDefense() + " " + hero.getHitPoints());
        }
    }
}
