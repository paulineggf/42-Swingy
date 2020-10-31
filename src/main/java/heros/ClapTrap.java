package heros;

class ClapTrap
{
    // Attributes
    private String  name;
    private String  artefact;
    private Levels  levels;
    private Powers  powers;

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
}

