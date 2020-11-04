package model.villains;
import model.heros.IHero;

public interface IVillains
{
    void    attack(IHero hero);
    void    getDamage(int damage);
    int     getXP();
    int     getAttack();
    int     getHitPoints();
}
