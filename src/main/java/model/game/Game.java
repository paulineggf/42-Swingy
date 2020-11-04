package model.game;

import model.heros.IHero;
import model.villains.Villains;

public class Game {
    // Enums
    private static final int    NORTH = 8;
    private static final int    SOUTH = 2;
    private static final int    EAST = 6;
    private static final int    WEST = 4;

    // Attributes
    public  IHero       hero;
    public  MyMap       map;
    public  MyPosition  pos;

    // Constructor
    public Game(IHero hero)
    {
        this.hero = hero;
        this.map = new MyMap(setMap());
        this.pos = new MyPosition(setPos());
    }

    // Methods
    private int     setMap()
    {
        return (((hero.getLevel() - 1) * 5) + 10 - 1);
    }

    private int     setPos()
    {
        return setMap() / 2;
    }

    public void     moveHero(int move)
    {
        if (move == NORTH)
            pos.y -= 1;
        else if (move == EAST)
            pos.x += 1;
        else if (move == SOUTH)
            pos.y += 1;
        else if (move == WEST)
            pos.x -= 1;
    }

    public  boolean     experienceUp(Villains villain)
    {
        hero.setExperience(villain.getXP() + (hero.getLevel() * 500));
        return levelUp();
    }

    private boolean    levelUp()
    {
        if (hero.getExperience() > ((hero.getLevel() * 1000) + (((hero.getLevel() - 1)^2) * 450)))
        {
            hero.setLevel(+1);
            return true;
        }
        return false;
    }
}
