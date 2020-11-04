package model.game;

public class MyPosition {
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
