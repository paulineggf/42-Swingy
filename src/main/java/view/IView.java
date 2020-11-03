package view;

import heros.IHero;

import java.io.IOException;
import java.util.ArrayList;

public interface IView {
    int     init();
    String  chooseClapTrap() throws IOException;
    String  chooseArtefact() throws IOException;
    String  chooseName() throws IOException;
    String  displayCharacters(ArrayList<IHero> heroSave) throws IOException;
}
