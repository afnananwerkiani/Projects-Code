package Paint;

import java.awt.*;

public class Triangle extends Polygon
{
    public Triangle(int[] x,int[] y)
    {
        super(x,y,3);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillPolygon(this);
    }
}