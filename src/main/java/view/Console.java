package view;

import model.game.Game;
import model.heros.IHero;
import model.villains.IVillain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Console implements IView {
    private static final int    GAMEOVER = 3;

    private static BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

    public int     menu() throws IOException {
        int gamerChoice;

        System.out.println("Welcome to Swingy!");

        System.out.println("You win the game if you reach on of the borders of the map.\n" +
                "Each turn you can move one position in one of the 4 four directions:\n" +
                "Press:\n" +
                "8 to move up\n" +
                "4 to move to the left\n" +
                "6 to move to the right\n" +
                "2 to move down\n");
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

    public void     wellSaved()
    {
        System.out.println("The game has been saved!");
    }

    public String   chooseSuperHero() throws IOException {
        String type;

        System.out.println("Choose a SuperHero");
        System.out.println("+------------+------------+------------+------------+");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Type", "Attack", "Defense", "Hit Points");
        System.out.printf("| %-10s | %-10d | %-10d | %-10d |\n", "Spiderman", 30, 10, 100);
        System.out.printf("| %-10s | %-10d | %-10d | %-10d |\n", "Superman", 20, 20, 100);
        System.out.printf("| %-10s | %-10d | %-10d | %-10d |\n", "Elasticman", 60, 30, 60);
        System.out.println("+------------+------------+------------+------------+");

        while (true) {
            type = br.readLine();
            if (type.equals("Spiderman") || type.equals("Superman") || type.equals("Elasticman"))
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

    public String     displayCharacters(ArrayList<Game> saveGames) throws IOException {
        String name;
        String state;

        System.out.println("Choose a SuperHero");
        System.out.println("+------------+------------+------------+------------+------------+------------+------------+------------+-------------+");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-11s |\n", "Name", "Type", "Level", "Experience", "Artefact", "Attack", "Defense", "Hit Points", " ");
        for (Game saveGame: saveGames) {
            if (saveGame.game == GAMEOVER)
                state = "Game Over";
            else
                state = "In Progress";
            System.out.printf("| %-10.10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-11s |\n", saveGame.hero.getName(), saveGame.hero.getType(), saveGame.hero.getLevel(), saveGame.hero.getExperience(), saveGame.hero.getArtefact(), saveGame.hero.getAttack(), saveGame.hero.getDefense(), saveGame.hero.getHitPoints(), state);
        }
        System.out.println("+------------+------------+------------+------------+------------+------------+------------+------------+-------------+");
        while (true) {
            name = br.readLine();
            for (Game saveGame: saveGames) {
                if (name.equals(saveGame.hero.getName()))
                    return name;
            }
            System.out.println("This character doesn't exist, please try again");
        }
    }

    public void     noCharacterSaved()
    {
        System.out.println("No character saved");
    }

    public void     characterGameOver()
    {
        System.out.println("You can't play this hero anymore, GAME OVER :(");
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
        System.out.println(hero.getName() + " attack the " + villain.getType() + "!");
        System.out.println("The " + villain.getType() + " loose " + hero.getAttack() + " hit points.");
    }

    public void     villainAttack(IHero hero, IVillain villain)
    {
        System.out.println("The " + villain.getType() + " attack " + hero.getName() + "!");
        System.out.println(hero.getName() + " loose " + (villain.getAttack() - hero.getDefense()) + " hit points.");
    }

    public void     getHitPoints(IHero hero, IVillain villain)
    {
        System.out.println(hero.getName() + " hit points: " + hero.getHitPoints());
        System.out.println(villain.getType() + " hit points: " + villain.getHitPoints());
        System.out.print("\n");
    }

    public int      continueToFightOrRun() throws IOException {
        String choice;

        System.out.println("Would you like to continue to fight (1) or run (2) ?");
        choice = "";
        while (choice.equals("") || (choice.equals("1") == false && choice.equals("2") == false))
            choice = br.readLine();
        return Integer.parseInt(choice);
    }

    public void     gameOver(IHero hero)
    {
        System.out.println(hero.getName() + " loose the game :(");
    }

    public void     levelUp(IHero hero)
    {
        System.out.println(hero.getName() + " is level up to level " + hero.getLevel() + "!");
    }

    public void     wonMap(IHero hero)
    {
        System.out.println(hero.getName() + " won the map!");
    }

    public int      saveContinueMenuExit() throws IOException {
        String choice;

        System.out.println("Would you like to:\n" +
                           "1/ Continue the game\n" +
                           "2/ Save the game\n" +
                           "3/ Go back to the main menu\n" +
                           "4/ Save and Exit");
        choice = "";
        while (choice.equals("") || (choice.equals("1") == false && choice.equals("2") == false
                && choice.equals("3") == false && choice.equals("4") == false))
            choice = br.readLine();
        return Integer.parseInt(choice);
    }

    public void     won(IHero hero)
    {
        System.out.println(hero.getName() + " has won! Congratulations!");
    }
}
