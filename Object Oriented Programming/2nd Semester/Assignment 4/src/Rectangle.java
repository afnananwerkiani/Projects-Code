import java.awt.*;

public class Rectangle extends Shapes
{
    private int x;
    private int y;
    private int length;
    private int height;
    private Color stroke_col;
    private Color button_col;
    private int stroke;

    public Rectangle(int x, int y, int length, int height, Color stroke_col, Color button_col, int stroke)
    {
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
        this.stroke_col = stroke_col;
        this.button_col = button_col;
        this.stroke = stroke;
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(stroke_col);
        g.fillRect(x, y, length, height);
        g.setColor(button_col);
        g.fillRect(x + stroke, y + stroke, length - 2 * stroke, height - 2 * stroke);
    }

    @Override
    public void increase(int x, int y) {

    }

}
