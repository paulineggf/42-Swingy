package view.console;

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

    public void     wonGame(String heroName)
    {
        System.out.println(heroName + " has won! Congratulations!");
    }

    public void     gameOver(String heroName)
    {
        System.out.println(heroName + " loose the game :(");
    }

    public void     wonMap(String heroName)
    {
        System.out.println(heroName + " won the map!");
    }

}
