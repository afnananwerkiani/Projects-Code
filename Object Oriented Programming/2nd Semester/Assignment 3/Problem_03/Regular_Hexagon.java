package Problem_03;

import java.awt.*;

public class Regular_Hexagon extends Polygon {
    private int[] x = new int[6];
    private int[] y = new int[6];
    private Polygon R_hexagon;

    private int[] calculateXPoints(int x_centre, int radius)
    {
        int[] x = new int[6];
        for (int i = 0; i < 6; i++) {
            x[i] = (int) (x_centre + (radius * Math.cos(2 * Math.PI / 6 * i)));
        }
        return x;
    }

    private int[] calculateYPoints(int y_centre, int radius)
    {
        int[] y = new int[6];
        for (int i = 0; i < 6; i++) {
            y[i] = (int) (y_centre + (radius * Math.sin(2 * Math.PI / 6 * i)));
        }
        return y;
    }

    public Regular_Hexagon(int centre_x, int centre_y, int radius)
    {
        x = calculateXPoints(centre_x, radius);
        y = calculateYPoints(centre_y, radius);
        R_hexagon = new Polygon(x, y, 6);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillPolygon(R_hexagon);
    }


}
