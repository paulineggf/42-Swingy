package model.villains;
import model.heros.IHero;

public class Witch extends Villains implements IVillain
{
    // Attributes
    private static String  type = "Witch";
    private static char    initials = 'W';

    // Constructor
    Witch(int hitPoints, int attack, int XP)
    {
        super(hitPoints, attack, XP);
    }

    public char getInitials()
    {
        return initials;
    }

    public String   getType()
    {
        return type;
    }
}



