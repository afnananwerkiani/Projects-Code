import java.awt.Color;
import java.awt.Graphics;

public class RegularHexagon extends Shapes {
    private int x, y, side, stroke;
    private Color strokeColor, buttonColor;

    public RegularHexagon(int x, int y, int side, Color strokeColor, Color buttonColor, int stroke) {
        this.x = x;
        this.y = y;
        this.side = side;
        this.stroke = stroke;
        this.strokeColor = strokeColor;
        this.buttonColor = buttonColor;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];

        for (int i = 0; i < 6; i++) {
            xPoints[i] = (int) (x + side * Math.cos(i * 2 * Math.PI / 6));
            yPoints[i] = (int) (y + side * Math.sin(i * 2 * Math.PI / 6));
        }

        g.setColor(buttonColor);
        g.fillPolygon(xPoints, yPoints, 6);

        for (int i = 0; i < 6 ; i++)
        {
            if(i == 0)
            {
                xPoints[i] -= stroke/2;
            }
            else if (i == 1)
            {
                xPoints[i] -= stroke/4;
                yPoints[i] -= stroke/2;
            }
            else if (i == 2)
            {
                xPoints[i] += stroke/4;
                yPoints[i] -= stroke/2;
            }
            else if (i == 3)
            {
                xPoints[i] += stroke/2;
            }
            else if (i == 4)
            {
                xPoints[i] += stroke/4;
                yPoints[i] += stroke/2;
            }
            else if (i == 5)
            {
                xPoints[i] -= stroke/4;
                yPoints[i] += stroke/2;
            }
        }

        g.setColor(strokeColor);
        g.fillPolygon(xPoints, yPoints, 6);
    }

    @Override
    public void increase(int x, int y) {

    }
}
