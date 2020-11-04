package model.heros;

import model.villains.IVillain;

import java.io.Serializable;

public interface IHero extends IClapTrap, Serializable
{
    // Getters
    String   getType();

    // Methods
    void attack(IVillain villain);
}
