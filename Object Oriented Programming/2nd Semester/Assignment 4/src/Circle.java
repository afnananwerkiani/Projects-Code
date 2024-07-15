import java.awt.*;

public class Circle extends Shapes
{
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius, Color but_col, Color str_col, int stroke)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.but_col = but_col;
        this.str_col = str_col;
        this.stroke = stroke;
    }

    private Color but_col;
    private Color str_col;
    private int stroke;



    @Override
    public void draw(Graphics g)
    {
        g.setColor(str_col);
        g.fillOval(x, y , radius, radius);
        g.setColor(but_col);
        g.fillOval(x+stroke,y+stroke,radius-(stroke*2),radius-(stroke*2));
    }

    @Override
    public void increase(int x, int y) {

    }
}
