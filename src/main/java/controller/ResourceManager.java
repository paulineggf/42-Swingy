package controller;

import model.game.Game;
import model.heros.IHero;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ResourceManager
{
    public static void      save(Serializable data, String fileName) throws Exception
    {
        boolean exist;

        File tmpDir = new File(fileName);
        exist = false;
        if (tmpDir.exists())
        {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
                ArrayList<Game> game = (ArrayList<Game>)ois.readObject();
                for (Game saveGame: game) {
                    if (saveGame.hero.getName().equals(((Game) data).hero.getName()))
                    {
                        saveGame = (Game) data;
                        exist = true;
                    }
                }
                if (exist == false)
                    game.add((Game) data);
                try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
                    oos.writeObject(game);
                }
            }
        }
        else
        {
            ArrayList<Game> game = new ArrayList<>();
            game.add((Game) data);
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
                oos.writeObject(game);
            }
        }
    }

    public static ArrayList<Game>    load(String fileName) throws Exception
    {
        File tmpDir = new File(fileName);
        if (tmpDir.exists())
        {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
                return (ArrayList<Game>) ois.readObject();
            }
        }
        else
            return null;
    }
}
