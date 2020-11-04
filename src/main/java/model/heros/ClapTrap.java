package model.heros;

import model.villains.IVillains;

import java.io.Serializable;

public class ClapTrap implements IClapTrap, Serializable
{
    private static final long   serialVersionUID = 1L;

    // Attributes
    protected String    name;
    protected String    artefact;
    protected Levels    levels;
    protected Powers    powers;

    // Constructor
    ClapTrap(String name, String artefact, Levels levels, Powers powers)
    {
        this.name = name;
        this.artefact = artefact;
        this.levels = levels;
        this.powers = powers;
    }

    // Getters
    public String   getName()
    {
        return name;
    }

    public String   getArtefact()
    {
        return artefact;
    }

    public int      getLevel()
    {
        return levels.getLevel();
    }

    public float    getExperience()
    {
        return levels.getXP();
    }

    public int      getAttack()
    {
        return powers.getAttack();
    }

    public int      getDefense()
    {
        return powers.getDefense();
    }

    public int      getHitPoints()
    {
        return powers.getHitPoints();
    }

    // Setters
    public void     setExperience(int XP)
    {
        levels.XP += XP;
    }

    public void     setLevel(int level)
    {
        levels.level += level;
    }

    // Methods
    public void     getDamage(int damage)
    {
        powers.hitPoints -= damage + powers.defense;
    }

    public void     attack(IVillains villain)
    {
        villain.getDamage(powers.attack);
    }
}
