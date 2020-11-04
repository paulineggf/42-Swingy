package model.game;

import java.io.Serializable;

public class MyMap implements Serializable {
    private static final long   serialVersionUID = 1L;

    int     x;
    int     y;

    MyMap(int map)
    {
        this.x = map;
        this.y = map;
    }

    public int     getX()
    {
        return x;
    }

    public int     getY()
    {
        return y;
    }
}
