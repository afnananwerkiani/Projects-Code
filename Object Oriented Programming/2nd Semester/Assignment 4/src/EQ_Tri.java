import java.awt.*;

public class EQ_Tri extends Shapes
{
    private int x;
    private int y;
    private int side;
    private int stroke;
    private Color but_col;
    private Color str_col;

    public EQ_Tri(int x, int y, int side, Color but_col, Color str_col, int stroke)
    {
        this.x = x;
        this.y = y;
        this.side = side;
        this.but_col = but_col;
        this.str_col = str_col;
        this.stroke = stroke;
    }

    @Override
    public void draw(Graphics g)
    {
        int x1 = x;
        int y1 = y;
        int x2 = x + side;
        int y2 = y;
        int x3 = x + side / 2;
        int y3 = (int) (y - Math.sqrt(3) * side / 2);
        int[] xPoints = {x1, x2, x3};
        int[] yPoints = {y1, y2, y3};
        g.setColor(str_col);
        g.fillPolygon(xPoints, yPoints, 3);
        for(int i = 0 ; i < xPoints.length ; i++)
        {
            int point_x = xPoints[i];
            int point_y = yPoints[i];
            if(point_y == y1 && point_x > x1)
            {
                xPoints[i] = point_x - stroke;
                yPoints[i] = point_y - stroke/2;
            }
            else if (point_x == x1)
            {
                xPoints[i] = point_x + stroke;
                yPoints[i] = point_y - stroke/2;
            }
            else
            {
                yPoints[i] = point_y + stroke;
            }
        }
        g.setColor(but_col);
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void increase(int x, int y) {

    }
}
