package model.heros;

import java.io.Serializable;

class Spiderman extends SuperHero implements IHero, Serializable
{
    private static final long   serialVersionUID = 1L;

    // Attributes
    private                 String  type = "Spiderman";
    private static final    int     hitPoints = 100;
    private static final    int     attack = 30;
    private static final    int     defense = 10;

    // Constructor
    Spiderman(String name, String artefact)
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
