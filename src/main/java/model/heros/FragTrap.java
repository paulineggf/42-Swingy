package model.heros;

import java.io.Serializable;

class FragTrap extends ClapTrap implements IHero, Serializable
{
    private static final long   serialVersionUID = 1L;

    // Attributes
    private String  type = "FragTrap";

    // Constructor
    FragTrap(String name, String artefact, Levels levels, Powers powers)
    {
        super(name, artefact, levels, powers);
    }

    // Getters
    public String  getType()
    {
        return type;
    }
}
