package Problem_03;

import java.awt.*;

public class Pentagram extends Polygon {
    private int[] x = new int[10];
    private int[] y = new int[10];
    private static Polygon R_pentagram;


    private int[] calculateXPoints(int x_centre, int radius)
    {
        int[] x = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                x[i] = (int) (x_centre + (radius * Math.cos(2 * Math.PI / 10 * i)));
            } else {
                x[i] = (int) (x_centre + (radius/2 * Math.cos(2 * Math.PI / 10 * i)));
            }
        }
        return x;
    }

    private int[] calculateYPoints(int y_centre, int radius)
    {
        int[] y = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                y[i] = (int) (y_centre + (radius * Math.sin(2 * Math.PI / 10 * i)));
            } else {
                y[i] = (int) (y_centre + (radius/2 * Math.sin(2 * Math.PI / 10 * i)));
            }
        }
        return y;
    }

    public Pentagram(int centre_x, int centre_y, int radius)
    {
        x = calculateXPoints(centre_x, radius);
        y = calculateYPoints(centre_y, radius);
        R_pentagram = new Polygon(x, y, 10);
    }

    public static void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillPolygon(R_pentagram);
    }
}

