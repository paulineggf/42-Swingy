package model.heros;

import java.io.Serializable;

public class Levels implements Serializable
{
    private static final long   serialVersionUID = 1L;

    // Attributes
    int     level;
    float   XP;

    // Constructor
    private Levels(Builder builder)
    {
        this.level = builder.level;
        this.XP = builder.experience;
    }

    // Builder
    public static class Builder
    {
        private int level;
        private int experience;

        public Builder level(int level)
        {
            this.level = level;
            return this;
        }

        public Builder experience(int experience)
        {
            this.experience = experience;
            return this;
        }

        public Levels   build()
        {
            return new Levels(this);
        }
    }

    // Getters
    int     getLevel()
    {
        return level;
    }

    float getXP()
    {
        return XP;
    }
}
