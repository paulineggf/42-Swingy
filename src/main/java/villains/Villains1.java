package villains;
import  heros.*;

public class Villains1 implements Villains
{
    // Attributes
    private int     hitPoints;
    private int     attack;

    // Constructor
    Villains1()
    {
        hitPoints = 200;
        attack = 20;
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
