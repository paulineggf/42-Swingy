package view;

import model.heros.IHero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Console implements IView {
    public int     init() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int gamerChoice;
            gamerChoice = 0;
            while (true) {
                System.out.println("Gamer choice: " + gamerChoice);
                System.out.println("Welcome to Swingy!");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String   chooseClapTrap() throws IOException {
        String type;
        type = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose a ClapTrap");
            System.out.println("+------------+------------+------------+------------+");
            System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Type", "Attack", "Defense", "Hit Points");
            System.out.println("+------------+------------+------------+------------+");
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
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return type;
    }

    public String   chooseArtefact() throws IOException {
        String artefact;

        artefact = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Choose an artefact");
            System.out.println("+------------+------------+------------+------------+");
            System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Artefact", "Attack", "Defense", "Hit Points");
            System.out.println("+------------+------------+------------+------------+");
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
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return artefact;
    }

    public String   chooseName() throws IOException {
        String name;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose a name for your hero");
        name = br.readLine();
        return name;

    }

    public String     displayCharacters(ArrayList<IHero> heroSave) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose a ClapTrap");
        for (IHero hero: heroSave) {
            System.out.println("Name      " + " type    " + " level " + " experience " + "Weapon   " + " attack " + " defense " + " hit points ");
            System.out.println(hero.getName() + " " + hero.getType() + " " + hero.getLevel() + " " + hero.getExperience() + " " + hero.getArtefact() + " " + hero.getAttack() + " " + hero.getDefense() + " " + hero.getHitPoints());
        }
        while (true) {
            String name = br.readLine();
            for (IHero hero: heroSave) {
                if (name.equals(hero.getName()))
                    return name;
            }
            System.out.println("This character doesn't exist, please try again");
        }
    }
}
