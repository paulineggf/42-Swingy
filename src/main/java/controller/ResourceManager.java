package controller;

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
        File tmpDir = new File(fileName);
        if (tmpDir.exists())
        {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
                ArrayList<IHero> heroSave = (ArrayList<IHero>)ois.readObject();
                heroSave.add((IHero) data);
                try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
                    oos.writeObject(heroSave);
                }
            }
        }
        else
        {
            ArrayList<IHero> heroSave = new ArrayList<IHero>();
            heroSave.add((IHero) data);
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
                oos.writeObject(heroSave);
            }
        }
    }

    public static ArrayList<IHero>    load(String fileName) throws Exception
    {
        File tmpDir = new File(fileName);
        if (tmpDir.exists())
        {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
                return (ArrayList<IHero>) ois.readObject();
            }
        }
        else
            return null;
    }
}
