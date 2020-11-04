package model.game;

import model.heros.IHero;
import model.villains.IVillains;
import model.villains.Villains;

import java.io.Serializable;

public class Game implements Serializable {
    private static final long   serialVersionUID = 1L;

    // Enums
    private static final int    NORTH = 8;
    private static final int    SOUTH = 2;
    private static final int    EAST = 6;
    private static final int    WEST = 4;

    private static final int    PROGRESS = 0;
    private static final int    LEVELUP = 1;
    private static final int    WON = 2;
    private static final int    GAMEOVER = 3;

    // Attributes
    public  IHero       hero;
    public  MyMap       map;
    public  MyPosition  pos;

    public  int         game;

    // Constructor
    public Game(IHero hero)
    {
        this.hero = hero;
        this.map = new MyMap(initMap());
        this.pos = new MyPosition(initPos());
        this.game = PROGRESS;
    }

    // Methods
    private int     initMap()
    {
        return (((hero.getLevel() - 1) * 5) + 10 - 1);
    }

    private int     initPos()
    {
        return initMap() / 2;
    }

    public void     resetMap()
    {
        map.x = initMap();
        map.y = initMap();
        resetPos();
    }

    private void     resetPos()
    {
        pos.x = initPos();
        pos.y = initPos();
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

    public  boolean     experienceUp(IVillains villain)
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
