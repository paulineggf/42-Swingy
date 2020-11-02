package heros;

import heros.IClapTrap;
import heros.Levels;
import heros.Powers;

import java.io.Serializable;

public class ClapTrap implements IClapTrap, Serializable
{
    // Attributes
    protected String  name;
    protected String  artefact;
    protected Levels levels;
    protected Powers powers;

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
        return levels.getExperience();
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

    // Methods
    public void     getDamage(int damage)
    {
        System.out.println(name + " loose " + (damage - powers.defense) + "...");
        powers.hitPoints -= damage + powers.defense;
    }
}
