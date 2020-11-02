package heros;

class ScavTrap extends ClapTrap implements IHero
{
    // Constructor
    ScavTrap(String name, String artefact, Levels levels, Powers powers)
    {
        super(name, artefact,  levels, powers);
    }

    // Methods
    public void     fight()
    {
        return;
    }

    public void     run()
    {
        return;
    }

}
