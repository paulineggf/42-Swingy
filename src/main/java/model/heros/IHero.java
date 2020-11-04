package model.heros;

import model.villains.IVillains;

import java.io.Serializable;

public interface IHero extends IClapTrap, Serializable
{
    // Getters
    String      getType();

    // Methods
    void        attack(IVillains villain);
}
