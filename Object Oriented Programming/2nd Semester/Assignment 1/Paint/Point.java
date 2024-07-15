package Paint;

public class Point
{

    int x = 0;
    int y = 0;

    public Point()
    {
        x=y=0;
    }
    public Point(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public Point(Point p)
    {
        x=p.x;
        y=p.y;
    }
}