package villains;
import  heros.*;

public class Villains2 implements Villains
{
    // Attributes
    private int     hitPoints;
    private int     attack;

    // Constructor
    Villains2()
    {
        hitPoints = 120;
        attack = 30;
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



