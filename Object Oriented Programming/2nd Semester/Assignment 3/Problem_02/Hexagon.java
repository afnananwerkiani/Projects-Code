package Paint;

import java.awt.*;

public class Hexagon extends Polygon
{
    public Hexagon(int[] x,int[] y)
    {
        super(x,y,6);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillPolygon(this);
    }
}