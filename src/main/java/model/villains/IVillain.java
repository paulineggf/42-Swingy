package model.villains;
import model.heros.IHero;

public interface IVillain
{
    public void attack(IHero hero);
    public void getDamage(int damage);
    public int  getXP();
}
