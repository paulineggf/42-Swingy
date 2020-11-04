package model.villains;
import model.heros.IHero;

public class Vampire extends Villains implements IVillain
{
    // Attributes
    private static String  type = "Vampire";
    private static char    initials = 'V';

    // Constructor
    Vampire(int hitPoints, int attack, int XP)
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



