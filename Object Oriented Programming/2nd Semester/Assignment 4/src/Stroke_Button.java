import java.awt.*;

public class Stroke_Button extends Button
{
    private int stroke = 0;
    public Stroke_Button(int x, int y, int length, int height)
    {
        super(x, y, length, height, Color.black, Color.white, "Stroke: 0");
    }

    public void setStroke()
    {
        if(stroke == 24)
        {
            stroke = 0;
        }
        else
        {
            stroke += 4;
        }
        this.setText("Stroke: "+stroke);
    }
    public int getStroke()
    {
        return stroke;
    }
}
