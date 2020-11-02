package villains;
import heros.IHero;
import org.jetbrains.annotations.NotNull;

public class Vampire extends Villains implements IVillain
{
    // Attributes
    private int     hitPoints;
    private int     attack;

    // Constructor
    Vampire(int hitPoints, int attack)
    {
        super(120, 30);
    }

    // Methods
    public void     attack(@NotNull IHero hero)
    {
        System.out.println("Vampire bites " + hero.getName());
        hero.getDamage(attack);
    }

    public void     getDamage(int damage)
    {
        hitPoints -= damage;
    }
}



