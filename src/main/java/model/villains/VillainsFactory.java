package model.villains;

public class VillainsFactory
{
    public IVillain newVillain(String type)
    {
        if (type.equals("Vampire") == true)
            return new Vampire(30, 50, 20);
        else if (type.equals("Zombie") == true)
            return new Zombie(20, 70, 30);
        else if (type.equals("Witch") == true)
            return new Witch(70, 60, 40);
        return null;
    }
}
