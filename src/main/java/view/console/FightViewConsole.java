package view.console;

public class FightViewConsole {
    public void villainAppear(String villainType) {
        System.out.println("No! A " + villainType + " is appearing!");
    }

    public void     fightOrRun()
    {
        System.out.println("Would you like to fight (1) or run (2) ?");
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
}
