package model.game;

import controller.GlobalVariables;
import model.heros.IHero;
import model.villains.IVillains;
import java.io.Serializable;

public class GameModel implements Serializable {
    private static final long   serialVersionUID = 1L;


    private static final int    PROGRESS = 0;
    private static final int    LEVELUP = 1;
    private static final int    WON = 2;
    private static final int    GAMEOVER = 3;

    // Attributes
    public  IHero       hero;
    public  MyMap       map;
    public  MyPosition  pos;

    public  int         state;

    // Constructor
    public GameModel(IHero hero)
    {
        this.hero = hero;
        this.map = new MyMap(initMap());
        this.pos = new MyPosition(initPos());
        this.state = PROGRESS;
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
        if (move == GlobalVariables.NORTH)
            pos.y -= 1;
        else if (move == GlobalVariables.EAST)
            pos.x += 1;
        else if (move == GlobalVariables.SOUTH)
            pos.y += 1;
        else if (move == GlobalVariables.WEST)
            pos.x -= 1;
    }

    public  boolean     experienceUp(IVillains villain)
    {
        if (villain != null)
            hero.setExperience(villain.getXP() + (hero.getLevel() * 500));
        else
            hero.setExperience(100);
        return levelUp();
    }

    private boolean    levelUp()
    {
        if (hero.getExperience() > ((hero.getLevel() * 1000) + (((hero.getLevel() - 1)^2) * 450))
            && hero.getLevel() < 5)
        {
            hero.setLevel(+1);
            return true;
        }
        return false;
    }
}
