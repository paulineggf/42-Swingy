package villains;
import  heros.*;

public class Villains3 implements Villains
{
    // Attributes
    private int     hitPoints;
    private int     attack;

    // Constructor
    Villains3()
    {
        hitPoints = 60;
        attack = 60;
    }

    // Methods
    public void     attack(Hero hero)
    {
        hero.getDamage(attack);
    }

    public void     getDamage(int damage)
    {
        hitPoints -= damage;
    }
}



