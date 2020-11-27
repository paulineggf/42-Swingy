package controller.console;

import controller.GlobalVariables;
import model.game.GameModel;
import model.villains.IVillain;
import view.console.FightViewConsole;

public class FightControllerConsole {

    private GameModel game;
    private IVillain villain;
    private FightViewConsole fightView = new FightViewConsole();

    FightControllerConsole(GameModel game, IVillain villain) {
        int  gamerChoice;

        this.game = game;
        this.villain = villain;
        fightView.villainAppear(villain.getType());
        gamerChoice = fightOrRun();
        if (gamerChoice == GlobalVariables.FIGHT)
            launchBattle();

    }

    private void launchBattle() {
        while (true) {
            // Hero Attack
            fightView.heroAttack(game.hero.getName(), villain.getType(), game.hero.getAttack());
            game.hero.attack(villain);
            fightView.getHitPoints(game.hero.getName(), villain.getType(), game.hero.getHitPoints(), villain.getHitPoints());

            // If Villain died = end of battle
            if (villain.getHitPoints() <= 0) {
                game.experienceUp(villain);
                fightView.levelUp(game.hero.getName(), game.hero.getLevel());
                break;
            }
            // Villain hit back
            fightView.villainAttack(game.hero.getName(), villain.getType(), villain.getAttack(), game.hero.getDefense());
            villain.attack(game.hero);
            fightView.getHitPoints(game.hero.getName(), villain.getType(), game.hero.getHitPoints(), villain.getHitPoints());

            // If Hero died = end of battle
            if (game.hero.getHitPoints() <= 0) {
                game.state = GlobalVariables.GAMEOVER;
                break;
            }

            // Choice to continue the fight or run away
            if (fightOrRun() == GlobalVariables.RUN) {
                break;
            }
        }
    }

    private int  fightOrRun() {
        String  line;
        int     gamerChoice;

        while (true)
        {
            fightView.fightOrRun();
            line = "";
            while (line == "")
                line = System.console().readLine();
            gamerChoice = Integer.parseInt(line);
            if (gamerChoice == GlobalVariables.RUN) {
                gamerChoice = randomFight();
                if (gamerChoice == GlobalVariables.FIGHT)
                    fightView.forceToFight();
                else
                    fightView.runAway();
            }
            else if (gamerChoice == GlobalVariables.ARTEFACT)
            {
                while (true)
                {
                    fightView.chooseArtefact();
                    String artefact = System.console().readLine();
                    if (artefact.equals("Weapon") || artefact.equals("Armor") || artefact.equals("Helm"))
                    {
                        game.hero.setArtefact(artefact);
                        break;
                    }
                    continue;

                }
                continue;
            }
            if (gamerChoice != GlobalVariables.RUN
                && gamerChoice != GlobalVariables.FIGHT
                && gamerChoice != GlobalVariables.ARTEFACT) {
                continue;
            }
            break;
        }
        return gamerChoice;
    }

    private int      randomFight() {
        int random;

        random = (int) ((Math.random() * 2) + 1);
        if (random == GlobalVariables.FIGHT)
            fightView.forceToFight();
        else
            fightView.runAway();
        return random;
    }
}
