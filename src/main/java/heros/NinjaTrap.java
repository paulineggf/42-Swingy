package heros;

class NinjaTrap extends ClapTrap implements Hero
{
    // Constructor
    NinjaTrap(String name, String artefact, Levels levels, Powers powers)
    {
        super(name, artefact, levels, powers);
    }

    // Methods
    public void    fight()
    {
        return;
    }

    public void    run()
    {
        return;
    }
}
