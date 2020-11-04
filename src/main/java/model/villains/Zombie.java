package model.villains;
import model.heros.IHero;

public class Zombie extends Villains implements IVillain
{
    // Constructor
    Zombie(int hitPoints, int attack, int XP)
    {
        super(hitPoints, attack, XP);
    }
}
