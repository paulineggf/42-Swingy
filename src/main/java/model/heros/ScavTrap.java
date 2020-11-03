package model.heros;

import java.io.Serializable;

class ScavTrap extends ClapTrap implements IHero, Serializable
{
    private static final long   serialVersionUID = 1L;

    // Attributes
    private String  type = "ScavTrap";

    // Constructor
    ScavTrap(String name, String artefact, Levels levels, Powers powers)
    {
        super(name, artefact,  levels, powers);
    }

    // Getters
    public String  getType()
    {
        return type;
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
