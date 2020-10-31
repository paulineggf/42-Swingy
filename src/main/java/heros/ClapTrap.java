package heros;

class ClapTrap
{

    // Attributes
    private String  name;
    private Levels  levels;
    private Powers  powers;

    // Constructor
    private ClapTrap(Builder builder)
    {
        this.name = builder.name;
        this.levels = builder.levels;
        this.powers = builder.powers;
    }

    // Builder
    public static class Builder
    {
        private String  name;
        private Levels  levels;
        private Powers  powers;

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        public Builder levels(Levels levels)
        {
            this.levels = levels;
            return this;
        }

        public Builder powers(Powers powers)
        {
            this.powers = powers;
            return this;
        }
    }

}

