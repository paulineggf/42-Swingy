package model.villains;
import model.heros.IHero;

public class Zombie extends Villains implements IVillain
{
    // Attributes
    private static String  type = "Zombie";
    private static char    initials = 'Z';

    // Constructor
    Zombie(int hitPoints, int attack, int XP)
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
