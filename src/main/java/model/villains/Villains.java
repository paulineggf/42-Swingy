package model.villains;

import model.heros.IHero;

public class Villains
{
    // Attributes
    protected int     hitPoints;
    protected int     attack;
    protected int     XP;

    // Constructor
    Villains(int hitPoints, int attack, int XP)
    {
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.XP = XP;
    }

    public void     attack(IHero hero)
    {
        hero.getDamage(attack);
    }

    public void     getDamage(int damage)
    {
        hitPoints -= damage;
    }

    public int      getXP() {
        return XP;
    }
}
