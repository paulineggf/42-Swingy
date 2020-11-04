package view;

import model.game.Game;
import model.heros.IHero;
import model.villains.IVillain;
import model.villains.Villains;

import java.io.IOException;
import java.util.ArrayList;

public interface IView {
    void    rules();
    int     init() throws IOException;
    String  chooseClapTrap() throws IOException;
    String  chooseArtefact() throws IOException;
    String  chooseName() throws IOException;
    String  displayCharacters(ArrayList<IHero> heroSave) throws IOException;
    void    displayMap(Game game, IVillain villain);
    int     moveHero(Game game) throws IOException;
    int     villainAppear(IVillain villain) throws IOException;
    void    forceToFight();
    void    runAway();
    void    heroAttack(IHero hero, IVillain villain);
    void    villainAttack(IHero hero, IVillain villain);
}

