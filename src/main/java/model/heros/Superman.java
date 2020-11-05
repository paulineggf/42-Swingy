package model.heros;

import java.io.Serializable;

class Superman extends SuperHero implements IHero, Serializable
{
    private static final long   serialVersionUID = 1L;

    // Attributes
    private String  type = "Superman";

    // Constructor
    Superman(String name, String artefact, Levels levels, Powers powers)
    {
        super(name, artefact,  levels, powers);
    }

    // Getters
    public String  getType()
    {
        return type;
    }
}
