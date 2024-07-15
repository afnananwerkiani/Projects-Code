package Paint;

import java.awt.*;

class Pentagon extends Polygon
{
    public Pentagon(int[] x,int[] y )
    {
        super(x,y,5);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillPolygon(this);
    }
}
