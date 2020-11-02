package game;

import heros.ClapTrap;
import heros.ClapTrapFactory;
import heros.IHero;

import java.io.*;

public class Game
{
    public static void  main(String[] args) throws ClassNotFoundException {
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
            System.out.println("          " + " attack " + " defense " + " hit points ");
            System.out.println("FragTrap  " + " 30     " + " 10      " + " 100        ");
            System.out.println("ScavTrap  " + " 20     " + " 20      " + " 100        ");
            System.out.println("NinjaTrap " + " 60     " + " 30      " + " 60         ");

            type = null;
            while (true)
            {
                type = br.readLine();
                if (type.equals("FragTrap") == true|| type.equals("ScavTrap") == true || type.equals("NinjaTrap") == true)
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
                if (artefact.equals("Weapon") == true || artefact.equals("Armor") == true || artefact.equals("Helm") == true)
                    break;
                System.out.println("Please try again");
            }

            System.out.println("Choose a name for your hero");
            name = br.readLine();

            hero = clapTrapFactory.newClapTrap(type, name, artefact);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("name.txt"));
            out.writeObject(hero);
            return hero;

        }
        catch (IOException ioe)
        {
            System.err.println(ioe);
        }
        return null;
    }

    private static IHero    loadGames() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("name.txt"));
        IHero hero = (IHero) in.readObject();
        System.out.println(hero.getName());
        return hero;
    }
}
