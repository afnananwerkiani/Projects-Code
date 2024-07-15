package Paint;

import java.awt.*;

public class Regular_Pentagon extends Polygon {
    private int[] x = new int[5];
    private int[] y = new int[5];
    private Polygon R_pentagon;

    private int[] calculateXPoints(int x_centre, int radius)
    {
        int[] x = new int[5];
        for (int i = 0; i < 5; i++) {
            x[i] = (int) (x_centre + (radius * Math.cos(2 * Math.PI / 5 * i)));
        }
        return x;
    }

    private int[] calculateYPoints(int y_centre, int radius)
    {
        int[] y = new int[5];
        for (int i = 0; i < 5; i++) {
            y[i] = (int) (y_centre + (radius * Math.sin(2 * Math.PI / 5 * i)));
        }
        return y;
    }

    public Regular_Pentagon(int centre_x, int centre_y, int radius)
    {
        x = calculateXPoints(centre_x, radius);
        y = calculateYPoints(centre_y, radius);
        R_pentagon = new Polygon(x, y, 5);
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillPolygon(R_pentagon);
    }
}