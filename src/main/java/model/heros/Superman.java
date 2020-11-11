package model.heros;

import java.io.Serializable;

class Superman extends SuperHero implements IHero, Serializable
{
    private static final long   serialVersionUID = 1L;

    // Attributes
    private                 String  type = "Superman";
    private final static    int     hitPoints = 100;
    private final static    int     attack = 20;
    private final static    int     defense = 20;

    // Constructor
    Superman(String name, String artefact)
    {
        super(name, artefact, new Levels.Builder().experience(0)
                                                  .level(0)
                                                  .build(),
                              new Powers.Builder().attack(attack)
                                                  .defense(defense)
                                                  .hitPoints(hitPoints)
                                                  .build());
    }

    // Getters
    public String  getType()
    {
        return type;
    }

    public void     resetHitPoints() {
        powers.hitPoints = hitPoints;
    }
}
