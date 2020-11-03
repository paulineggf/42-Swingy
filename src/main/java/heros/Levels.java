package heros;

import java.io.Serializable;

public class Levels implements Serializable
{
    private static final long   serialVersionUID = 1L;

    // Attributes
    int     level;
    float   experience;

    // Constructor
    private Levels(Builder builder)
    {
        this.level = builder.level;
        this.experience = builder.experience;
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

    float   getExperience()
    {
        return experience;
    }
}
