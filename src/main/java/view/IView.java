package view;

import model.game.Game;
import model.heros.IHero;

import java.io.IOException;
import java.util.ArrayList;

public interface IView {
    int     init() throws IOException;
    String  chooseClapTrap() throws IOException;
    String  chooseArtefact() throws IOException;
    String  chooseName() throws IOException;
    String  displayCharacters(ArrayList<IHero> heroSave) throws IOException;
    void    displayMap(Game game);
    int     moveHero(Game game) throws IOException;
}
