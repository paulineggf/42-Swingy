package villains;
import heros.IHero;

public class Zombie extends Villains implements IVillain
{
    // Attributes
    private int     hitPoints;
    private int     attack;

    // Constructor
    Zombie(int hitPoints, int attack)
    {
        super(200, 20);
    }

    // Methods
    public void     attack(IHero hero)
    {
        hero.getDamage(attack);
    }

    public void     getDamage(int damage)
    {
        hitPoints -= damage;
    }
}
