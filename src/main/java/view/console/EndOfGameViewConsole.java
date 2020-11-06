package view.console;

public class EndOfGameViewConsole {
    public void     setView() {
        System.out.println("Would you like to:\n" +
                "1/ Continue the game\n" +
                "2/ Go back to the main menu\n" +
                "3/ Exit");
    }

    public void     wellSaved()
    {
        System.out.println("The game has been saved!");
    }

}
