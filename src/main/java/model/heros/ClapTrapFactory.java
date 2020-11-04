package model.heros;

public class ClapTrapFactory
{
    public static IHero newClapTrap(String type, String name, String artefact)
    {
        int attack;
        int defense;
        int hitPoints;

        attack = 0;
        defense = 0;
        hitPoints = 0;
        if (type.equals("FragTrap") == true)
        {
            attack = 30;
            defense = 10;
            hitPoints = 100;
        }
        else if (type.equals("ScavTrap") == true)
        {
            attack = 20;
            defense = 20;
            hitPoints = 100;
        }
        else if (type.equals("NinjaTrap") == true)
        {
            attack = 60;
            defense = 30;
            hitPoints = 60;
        }

        Powers powers = new Powers.Builder().attack(attack)
                                            .defense(defense)
                                            .hitPoints(hitPoints)
                                            .build();

        Levels levels = new Levels.Builder().experience(0)
                                            .level(0)
                                            .build();

        if (type.equals("FragTrap") == true)
            return new FragTrap(name, artefact, levels, powers);
        else if (type.equals("ScavTrap") == true)
            return new ScavTrap(name, artefact, levels, powers);
        else if (type.equals("NinjaTrap") == true)
            return new NinjaTrap(name, artefact, levels, powers);
        return null;
    }
}
