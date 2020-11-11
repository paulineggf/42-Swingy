package model.heros;

import model.villains.IVillains;

import java.io.Serializable;

public interface IHero extends ISuperHero, Serializable
{
    // Getters
    String      getType();

    // Methods
    void        attack(IVillains villain);

    void        resetHitPoints();
}
