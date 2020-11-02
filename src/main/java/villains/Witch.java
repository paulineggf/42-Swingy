package villains;
import heros.IHero;

public class Witch extends Villains implements IVillain
{
    // Attributes
    private int     hitPoints;
    private int     attack;

    // Constructor
    Witch(int hitPoints, int attack)
    {
        super(60, 60);
    }

    // Methods
    public void     attack(IHero hero)
    {
        System.out.println("Karaba the witch has cast a terrible spell on " + hero.getName());
        hero.getDamage(attack);
    }

    public void     getDamage(int damage)
    {
        hitPoints -= damage;
    }
}



