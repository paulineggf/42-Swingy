package heros;

import java.io.Serializable;

public class Powers implements Serializable
{
    private static final long   serialVersionUID = 1L;

    // Attributes
    int     attack;
    int     defense;
    int     hitPoints;

    // Constructor
    private Powers(Builder builder)
    {
        this.attack = builder.attack;
        this.defense = builder.defense;
        this.hitPoints = builder.hitPoints;
    }

    // Builder
    public static class Builder
    {
        private int attack;
        private int defense;
        private int hitPoints;

        public Builder  attack(int attack)
        {
            this.attack = attack;
            return this;
        }

        public Builder  defense(int defense)
        {
            this.defense = defense;
            return this;
        }

        public Builder  hitPoints(int hitPoints)
        {
            this.hitPoints = hitPoints;
            return this;
        }

        public Powers   build()
        {
            return new Powers(this);
        }
    }

    // Getters
    int     getAttack()
    {
        return attack;
    }

    int     getDefense()
    {
        return defense;
    }

    int     getHitPoints()
    {
        return hitPoints;
    }
}
