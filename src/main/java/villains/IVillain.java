package villains;
import heros.IHero;

public interface IVillain
{
    public void attack(IHero hero);
    public void getDamage(int damage);
}
