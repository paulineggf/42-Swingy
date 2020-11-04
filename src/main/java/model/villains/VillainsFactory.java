package model.villains;

public class VillainsFactory
{
    public static IVillain newVillain(int type)
    {
        if (type == 1)
            return new Vampire(30, 50, 20);
        else if (type == 2)
            return new Zombie(20, 70, 30);
        else if (type == 3)
            return new Witch(70, 60, 40);
        return null;
    }
}
