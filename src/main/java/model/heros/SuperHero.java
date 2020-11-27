package model.heros;

import model.villains.IVillains;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class SuperHero implements ISuperHero, Serializable
{
    private static final long   serialVersionUID = 1L;

    // Attributes
    @NotBlank(message = "must have a value")
    protected String    name;
    @NotBlank(message = "must have a value")
    protected String    artefact;
    @Valid
    protected Levels    levels;
    @Valid
    protected Powers    powers;

    // Constructor
    SuperHero(String name, String artefact, Levels levels, Powers powers)
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
        if (artefact.equals("Weapon"))
            return powers.getAttack() + 20;
        return powers.getAttack();
    }

    public int      getDefense()
    {
        if (artefact.equals("Armor"))
            return powers.getDefense() + 20;
        return powers.getDefense();
    }

    public int      getHitPoints()
    {
        if (artefact.equals("Helm"))
            return powers.getHitPoints() + 20;
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

    public void     setArtefact(String artefact) {
        this.artefact = artefact;
    }

    // Methods
    public void     getDamage(int damage) {
        powers.hitPoints = (powers.hitPoints - damage) + getDefense();
    }

    public void     attack(IVillains villain) {
        villain.getDamage(getAttack());
    }


}
