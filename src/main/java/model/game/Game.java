package model.game;

import model.heros.IHero;
import model.villains.Villains;

public class Game {
    // Attributes
    private IHero       hero;
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
        if (move == 8)
            pos.y -= 1;
        else if (move == 6)
            pos.x += 1;
        else if (move == 2)
            pos.y += 1;
        else if (move == 4)
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
