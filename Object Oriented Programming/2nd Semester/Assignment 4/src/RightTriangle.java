import java.awt.*;

public class RightTriangle extends Shapes
{
    private int x, y, base, height, stroke;
    private Color strokeColor, buttonColor;

    public RightTriangle(int x, int y, int radius, Color strokeColor, Color buttonColor , int stroke) {
        this.x = x;
        this.y = y;
        this.base = radius;
        this.height = radius;
        this.stroke = stroke;
        this.strokeColor = strokeColor;
        this.buttonColor = buttonColor;
    }

    @Override
    public void draw(Graphics g) {
        int x1 = x;
        int y1 = y;
        int x2 = x + base;
        int y2 = y;
        int x3 = x;
        int y3 = y - height;

        int[] xPoints = {x1, x2, x3};
        int[] yPoints = {y1, y2, y3};

        g.setColor(buttonColor);
        g.fillPolygon(xPoints, yPoints, 3);
        for(int i = 0 ; i < xPoints.length ; i++)
        {
            int point_x = xPoints[i];
            int point_y = yPoints[i];
            if(point_x == x1 && point_y < y1)
            {
                xPoints[i] = point_x + stroke/2;
                yPoints[i] = point_y + stroke;
            }
            else if (point_x == x1 && point_y == y1)
            {
                xPoints[i] = point_x + stroke/2;
                yPoints[i] = point_y - stroke/2;
            }
            else
            {
                xPoints[i] = point_x - stroke;
                yPoints[i] = point_y - stroke/2;
            }
        }
        g.setColor(strokeColor);
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void increase(int x, int y) {

    }
}

