package view.console;

import model.game.GameModel;
import model.heros.IHero;

public class LaunchGameViewConsole {

    public void     displayMap(int heroX, int heroY, int mapX, int mapY, char villainInitials)
    {
        for (int j = 0; j < mapY; j++)
        {
            for (int i = 0; i < mapX; i++)
                System.out.print("+----");
            System.out.println("+");
            for (int i = 0; i < mapX; i++)
            {
                if (heroY == j && heroX == i)
                    System.out.printf("| H%c ", villainInitials);
                else
                    System.out.printf("|%-4s", " ");
            }
            System.out.println("|");
        }
        for (int i = 0; i < mapX; i++)
            System.out.print("+----");
        System.out.println("+");
    }

    public void     moveHero()
    {
        System.out.println("Move your hero:");
    }

    public void     won(String name)
    {
        System.out.println(name + " has won! Congratulations!");
    }
}
