package model.villains;
import model.heros.IHero;

public interface IVillain
{
    void    attack(IHero hero);
    void    getDamage(int damage);
    int     getXP();
    char    getInitials();
    int     getAttack();
    String  getType();
    int     getHitPoints();
}
