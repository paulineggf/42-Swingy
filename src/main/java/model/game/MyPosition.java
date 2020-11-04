package model.game;

import java.io.Serializable;

public class MyPosition implements Serializable {
    private static final long   serialVersionUID = 1L;

    int     x;
    int     y;

    MyPosition(int pos)
    {
        this.x = pos;
        this.y = pos;
    }

    public int  getX()
    {
        return x;
    }

    public int  getY()
    {
        return y;
    }
}
