import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class Layer extends Button implements Serializable
{


    private final ArrayList<Shapes> shapes = new ArrayList<>();

    private final Stack<Shapes> stack = new Stack<>();

    public Layer(int x, int y, int length, int height, String text) {
        super(x, y, length, height, Color.BLACK, Color.GRAY, text);
    }

    public void add(Shapes shape)
    {
        shapes.add(shape);
    }

    public void draw(Graphics g)
    {
        for(Shapes shape:shapes)
        {
            shape.draw(g);
        }
    }

    public void undo()
    {
        System.out.println("Undo");
    }

    public void redo()
    {
        System.out.println("Redo");
    }
}
