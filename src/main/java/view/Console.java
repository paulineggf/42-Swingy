package view;

import model.game.Game;
import model.heros.IHero;
import model.villains.IVillain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Console implements IView {
    private static BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

    public int     init() throws IOException {
        int gamerChoice;
        gamerChoice = 0;
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("1. New game");
            System.out.println("2. Load save game");
            System.out.println("3. Exit");
            gamerChoice = Integer.parseInt(br.readLine());
            if (gamerChoice == 1 || gamerChoice == 2)
                return gamerChoice;
            else if (gamerChoice == 3)
                System.exit(0);
            System.out.println("Please try again");
        }
    }

    public String   chooseClapTrap() throws IOException {
        String type;

        System.out.println("Choose a ClapTrap");
        System.out.println("+------------+------------+------------+------------+");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Type", "Attack", "Defense", "Hit Points");
        System.out.printf("| %-10s | %-10d | %-10d | %-10d |\n", "FragTrap", 30, 10, 100);
        System.out.printf("| %-10s | %-10d | %-10d | %-10d |\n", "ScavTrap", 20, 20, 100);
        System.out.printf("| %-10s | %-10d | %-10d | %-10d |\n", "NinjaTrap", 60, 30, 60);
        System.out.println("+------------+------------+------------+------------+");

        while (true) {
            type = br.readLine();
            if (type.equals("FragTrap") || type.equals("ScavTrap") || type.equals("NinjaTrap"))
                break;
            System.out.println("Please try again");
        }
        return type;
    }

    public String   chooseArtefact() throws IOException {
        String artefact;

        System.out.println("Choose an artefact");
        System.out.println("+------------+------------+------------+------------+");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Artefact", "Attack", "Defense", "Hit Points");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Weapon", "+20", "0", "0");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Armor", "0", "+20", "0");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Helm", "0", "0", "+20");
        System.out.println("+------------+------------+------------+------------+");

        while (true) {
            artefact = br.readLine();
            if (artefact.equals("Weapon") || artefact.equals("Armor") || artefact.equals("Helm"))
                break;
            System.out.println("Please try again");
        }
        return artefact;
    }

    public String   chooseName() throws IOException {
        String name;

        System.out.println("Choose a name for your hero");
        name = br.readLine();
        return name;
    }

    public String     displayCharacters(ArrayList<IHero> heroSave) throws IOException {
        String name;

        System.out.println("Choose a ClapTrap");
        System.out.println("+------------+------------+------------+------------+------------+------------+------------+------------+");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "Name", "Type", "Level", "Experience", "Artefact", "Attack", "Defense", "Hit Points");
        for (IHero hero: heroSave) {
            System.out.printf("| %-10.10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", hero.getName(), hero.getType(), hero.getLevel(), hero.getExperience(), hero.getArtefact(), hero.getAttack(), hero.getDefense(), hero.getHitPoints());
        }
        System.out.println("+------------+------------+------------+------------+------------+------------+------------+------------+");
        while (true) {
            name = br.readLine();
            for (IHero hero: heroSave) {
                if (name.equals(hero.getName()))
                    return name;
            }
            System.out.println("This character doesn't exist, please try again");
        }
    }

    public void     displayMap(Game game, IVillain villain)
    {
        for (int j = 0; j < game.map.getY(); j++)
        {
            for (int i = 0; i < game.map.getX(); i++)
                System.out.print("+----");
            System.out.println("+");
            for (int i = 0; i < game.map.getX(); i++)
            {
                if (game.pos.getY() == j && game.pos.getX() == i && villain != null)
                    System.out.printf("| H%c ", villain.getInitials());
                else if (game.pos.getY() == j && game.pos.getX() == i)
                    System.out.printf("| H  ");
                else
                   System.out.printf("|%-4s", " ");
            }
            System.out.println("|");
        }
        for (int i = 0; i < game.map.getX(); i++)
            System.out.print("+----");
        System.out.println("+");
    }

    public int      moveHero(Game game) throws IOException {
        int     move;
        String  line;

        System.out.println("Move your hero:");
        line = br.readLine();
        if (line.equals("") == false)
            move = Integer.parseInt(line);
        else
            move = 0;
        return move;
    }

    public void     rules()
    {
        System.out.println("Welcome to Swingy!");

        System.out.println("You win the game if you reach on of the borders of the map." +
                            "Each turn you can move one position in one of the 4 four directions:\n" +
                            "Press:\n" +
                            "8 to move up\n" +
                            "4 to move to the left\n" +
                            "6 to move to the right\n" +
                            "2 to move down\n");
    }

    public int       villainAppear(IVillain villain) throws IOException {
        String choice;

        System.out.println("No! A " + villain.getType() + " appear!");
        System.out.println("Would you like to fight (1) or run (2) ?");
        choice = "";
        while (choice.equals("") || (choice.equals("1") == false && choice.equals("2") == false))
            choice = br.readLine();
        return Integer.parseInt(choice);
    }

    public void     forceToFight()
    {
        System.out.println("You can't run! You have to fight!!");
    }

    public void     runAway()
    {
        System.out.println("You managed to escape!!");
    }

    public void     heroAttack(IHero hero, IVillain villain)
    {
        System.out.println(hero.getName() + " attack " + villain.getType() + "!");
        System.out.println(villain.getType() + " loose " + hero.getAttack() + " hit points.");
        System.out.println(hero.getName() + " hit points: " + hero.getHitPoints());
        System.out.println(villain.getType() + " hit points: " + villain.getType());
    }

    public void     villainAttack(IHero hero, IVillain villain)
    {
        System.out.println(villain.getType() + " attack " + hero.getName() + "!");
        System.out.println(hero.getName() + " loose " + (villain.getAttack() - hero.getDefense()) + " hit points.");
        System.out.println(hero.getName() + " hit points: " + hero.getHitPoints());
        System.out.println(villain.getType() + " hit points: " + villain.getType());
    }
}
