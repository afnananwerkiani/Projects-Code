import java.awt.*;
import java.util.ArrayList;

public class Free_Draw extends Shapes
{
    private ArrayList<Circle> circles = new ArrayList<>();
    private int stroke;
    private Color line_col;

    public Free_Draw(int stroke , Color line_col)
    {
        this.stroke = stroke;
        this.line_col = line_col;
    }

    public void increase(int x,int y)
    {
        circles.add(new Circle(x,y,stroke,line_col,line_col,stroke));
    }


    @Override
    public void draw(Graphics g)
    {
        for(Circle c:circles)
        {
            c.draw(g);
        }
    }
}
