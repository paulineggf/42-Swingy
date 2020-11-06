package view.console;

public class NewGameViewConsole {

    public NewGameViewConsole() {}

    public void     chooseSuperHero()
    {
        System.out.println("Choose a SuperHero");
        System.out.println("+------------+------------+------------+------------+");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Type", "Attack", "Defense", "Hit Points");
        System.out.printf("| %-10s | %-10d | %-10d | %-10d |\n", "Spiderman", 30, 10, 100);
        System.out.printf("| %-10s | %-10d | %-10d | %-10d |\n", "Superman", 20, 20, 100);
        System.out.printf("| %-10s | %-10d | %-10d | %-10d |\n", "Elasticman", 60, 30, 60);
        System.out.println("+------------+------------+------------+------------+");
    }

    public void     chooseArtefact()
    {
        System.out.println("Choose an artefact");
        System.out.println("+------------+------------+------------+------------+");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Artefact", "Attack", "Defense", "Hit Points");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Weapon", "+20", "0", "0");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Armor", "0", "+20", "0");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Helm", "0", "0", "+20");
        System.out.println("+------------+------------+------------+------------+");
    }

    public void     chooseName()
    {
        System.out.println("Choose a name for your hero");
    }

    public void     error()
    {
        System.out.println("Please try again");
    }
}
