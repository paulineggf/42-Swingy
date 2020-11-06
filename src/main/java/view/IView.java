package view;

import model.game.GameModel;
import model.heros.IHero;
import model.villains.IVillain;

import java.io.IOException;
import java.util.ArrayList;

public interface IView {
    int     menu() throws IOException;
    String  chooseSuperHero() throws IOException;
    String  chooseArtefact() throws IOException;
    String  chooseName() throws IOException;
    String  displayCharacters(ArrayList<GameModel> saveGames) throws IOException;
    void    displayMap(GameModel game, IVillain villain);
    int     moveHero(GameModel game) throws IOException;
    int     villainAppear(IVillain villain) throws IOException;
    void    forceToFight();
    void    runAway();
    void    heroAttack(IHero hero, IVillain villain);
    void    villainAttack(IHero hero, IVillain villain);
    void    getHitPoints(IHero hero, IVillain villain);
    int     continueToFightOrRun() throws IOException;
    void    gameOver(IHero hero);
    void    levelUp(IHero hero);
    void    wonMap(IHero hero);
    int     saveContinueMenuExit() throws IOException;
    void    noCharacterSaved();
    void    wellSaved();
    void    won(IHero hero);
    void    characterGameOver();
}

