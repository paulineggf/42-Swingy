package controller;

import model.game.GameModel;

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
        File tmpDir = new File(fileName);
        int index;

        if (tmpDir.exists())
        {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
                ArrayList<GameModel> game = (ArrayList<GameModel>)ois.readObject();
                index = 0;
                for (GameModel saveGame: game) {

                    if (saveGame.hero.getName().equals(((GameModel) data).hero.getName()))
                    {
                        game.remove(index);
                        break;
                    }
                    index++;
                }
                game.add(0, (GameModel) data);
                try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
                    oos.writeObject(game);
                }
            }
        }
        else
        {
            ArrayList<GameModel> game = new ArrayList<>();
            game.add((GameModel) data);
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
                oos.writeObject(game);
            }
        }
    }

    public static ArrayList<GameModel>    load(String fileName) throws Exception
    {
        File tmpDir = new File(fileName);
        if (tmpDir.exists())
        {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
                return (ArrayList<GameModel>) ois.readObject();
            }
        }
        else
            return null;
    }
}
