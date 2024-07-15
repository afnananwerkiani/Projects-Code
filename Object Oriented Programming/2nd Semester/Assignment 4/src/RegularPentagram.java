import java.awt.Color;
import java.awt.Graphics;

public class RegularPentagram extends Shapes {
    private int x, y, radius, stroke ;
    private Color strokeColor, buttonColor;

    private int[] x_points , y_points , in_x_points , in_y_points = new int[10];

    public RegularPentagram(int x, int y, int radius, Color strokeColor, Color buttonColor , int stroke)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.stroke = stroke;
        this.strokeColor = strokeColor;
        this.buttonColor = buttonColor;
        x_points = calculateXPoints();
        y_points = calculateYPoints();
        in_x_points = calculate_innerXPoints();
        in_y_points = calculate_innerYPoints();
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(buttonColor);
        g.fillPolygon(x_points,y_points,10);
        g.setColor(strokeColor);
        g.fillPolygon(in_x_points,in_y_points,10);
    }

    @Override
    public void increase(int x, int y) {

    }

    private int[] calculateXPoints()
    {
        int[] x = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                x[i] = (int) (this.x + (radius * Math.cos(2 * Math.PI / 10 * i)));
            } else {
                x[i] = (int) (this.x + (radius/2 * Math.cos(2 * Math.PI / 10 * i)));
            }
        }
        return x;
    }

    private int[] calculateYPoints()
    {
        int[] y = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                y[i] = (int) (this.y + (radius * Math.sin(2 * Math.PI / 10 * i)));
            } else {
                y[i] = (int) (this.y + (radius/2 * Math.sin(2 * Math.PI / 10 * i)));
            }
        }
        return y;
    }

    private int[] calculate_innerXPoints()
    {
        int[] x = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                x[i] = (int) (this.x + ((radius-stroke) * Math.cos(2 * Math.PI / 10 * i)));
            } else {
                x[i] = (int) (this.x + ((radius-stroke)/2 * Math.cos(2 * Math.PI / 10 * i)));
            }
        }
        return x;
    }

    private int[] calculate_innerYPoints()
    {
        int[] y = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                y[i] = (int) (this.y + ((radius-stroke) * Math.sin(2 * Math.PI / 10 * i)));
            } else {
                y[i] = (int) (this.y + ((radius-stroke)/2 * Math.sin(2 * Math.PI / 10 * i)));
            }
        }
        return y;
    }
}
