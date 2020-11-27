package model.heros;

import javax.validation.Valid;

public class SuperHeroFactory
{
    public static IHero newSuperHero(String type, String name, String artefact)
    {
        switch (type) {
            case "Spiderman":
                return new Spiderman(name, artefact);
            case "Superman":
                return new Superman(name, artefact);
            case "Elasticman":
                return new Elasticman(name, artefact);
        }
        return null;
    }
}
