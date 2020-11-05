package model.villains;

public class VillainsFactory
{
    private static final int    VAMPIRE = 1;
    private static final int    ZOMBIE = 2;
    private static final int    WITCH = 3;

    public static IVillain newVillain(int type)
    {
        if (type == VAMPIRE)
            return new Vampire(30, 50, 20);
        else if (type == ZOMBIE)
            return new Zombie(20, 60, 30);
        else if (type == WITCH)
            return new Witch(50, 50, 40);
        return null;
    }
}
