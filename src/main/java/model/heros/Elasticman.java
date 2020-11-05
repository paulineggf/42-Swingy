package model.heros;

import java.io.Serializable;

class Elasticman extends SuperHero implements IHero, Serializable
{
    private static final long   serialVersionUID = 1L;

    // Attributes
    private String  type = "Elasticman";

    // Constructor
    Elasticman(String name, String artefact, Levels levels, Powers powers)
    {
        super(name, artefact, levels, powers);
    }

    // Getters
    public String  getType()
    {
        return type;
    }
}
