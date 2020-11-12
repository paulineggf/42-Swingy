package view.console;

import controller.GlobalVariables;
import model.game.GameModel;

import java.util.ArrayList;

public class LoadGameViewConsole {

    public void     displayCharacters(ArrayList<GameModel> saveGames)
    {
        String name;
        String state;

        System.out.println("Choose a SuperHero: (to delete a game, write the \"[name] + delete\" OR write \"menu\" to come back to the main menu)");
        System.out.println("+------------+------------+------------+------------+------------+------------+------------+------------+-------------+");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-11s |\n", "Name", "Type", "Level", "Experience", "Artefact", "Attack", "Defense", "Hit Points", " ");
        for (GameModel saveGame: saveGames) {
            if (saveGame.state == GlobalVariables.GAMEOVER)
                state = "Game Over";
            else
                state = "In Progress";
            System.out.printf("| %-10.10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-11s |\n", saveGame.hero.getName(), saveGame.hero.getType(), saveGame.hero.getLevel(), saveGame.hero.getExperience(), saveGame.hero.getArtefact(), saveGame.hero.getAttack(), saveGame.hero.getDefense(), saveGame.hero.getHitPoints(), state);
        }
        System.out.println("+------------+------------+------------+------------+------------+------------+------------+------------+-------------+");
    }

    public void     characterGameOver()
    {
        System.out.println("You can't play this hero anymore, GAME OVER :(");
    }

    public void     noCharacterSaved()
    {
        System.out.println("No character saved");
    }

    public void     error()
    {
        System.out.println("Please try again.");
    }

    public void     characterNotExit() { System.out.println("This character doesn't exist."); }
}
