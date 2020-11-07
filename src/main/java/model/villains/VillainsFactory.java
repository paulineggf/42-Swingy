package model.villains;

import controller.GlobalVariables;

public class VillainsFactory
{
    public static IVillain newVillain(int type)
    {
        if (type == GlobalVariables.VAMPIRE)
            return new Vampire(30, 50, 20);
        else if (type == GlobalVariables.ZOMBIE)
            return new Zombie(20, 60, 30);
        else if (type == GlobalVariables.WITCH)
            return new Witch(50, 50, 40);
        return null;
    }
}
