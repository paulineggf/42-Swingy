package model.heros;

import java.io.Serializable;

public interface IHero extends IClapTrap, Serializable
{
    // Getters
    String   getType();

    // Methods
    void     fight();
    void     run();
}
