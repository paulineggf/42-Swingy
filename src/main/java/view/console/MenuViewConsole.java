package view.console;

public class MenuViewConsole {

    public MenuViewConsole() {}

    public void     setVisible()
    {
        System.out.println("Welcome to Swingy!");

        System.out.println("You win the game if you reach on of the borders of the map.\n" +
                "Each turn you can move one position in one of the 4 four directions:\n" +
                "Press:\n" +
                "8 to move up\n" +
                "4 to move to the left\n" +
                "6 to move to the right\n" +
                "2 to move down\n");

        System.out.println("What do you want to do?");
        System.out.println("1. New game");
        System.out.println("2. Load save game");
        System.out.println("3. Exit");
    }

    public void     error()
    {
        System.out.println("Please try again");
    }
}
