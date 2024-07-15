package Problem_03;


import java.awt.*;

public class Quadrilateral extends Polygon
{
    public Quadrilateral(int[] x,int[] y)

    {
        super(x,y,4);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillPolygon(this);
    }
}

