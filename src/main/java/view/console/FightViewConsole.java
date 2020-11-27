package view.console;

public class FightViewConsole {
    public void villainAppear(String villainType) {
        System.out.println("No! A " + villainType + " appear!");
    }

    public void     fightOrRun()
    {
        System.out.println("Would you like to fight (1) or run (2) ?");
        System.out.println("You can also change of artefact (3)" );
    }

    public void     forceToFight()
    {
        System.out.println("You can't run! You have to fight!!");
    }

    public void     runAway()
    {
        System.out.println("You managed to escape!!");
    }

    public void     heroAttack(String heroName, String villainType, int heroAttack)
    {
        System.out.println(heroName + " attack the " + villainType + "!");
        System.out.println("The " + villainType + " loose " + heroAttack + " hit points.");
    }

    public void     villainAttack(String heroName, String villainType, int villainAttack, int heroDefense)
    {
        System.out.println("The " + villainType + " attack " + heroName + "!");
        System.out.println(heroName + " loose " + (villainAttack - heroDefense) + " hit points.");
    }

    public void     getHitPoints(String heroName, String villainType, int heroHitPoints, int villainHitPoints)
    {
        System.out.println(heroName+ " hit points: " + heroHitPoints);
        System.out.println(villainType + " hit points: " + villainHitPoints);
        System.out.print("\n");
    }

    public void     levelUp(String heroName, int heroLevel)
    {
        System.out.println(heroName + " is level up to level " + heroLevel + "!");
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
}
