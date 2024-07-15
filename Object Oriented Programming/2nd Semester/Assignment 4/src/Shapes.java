import java.awt.*;
import java.io.Serializable;

public abstract class Shapes implements Serializable {
    public abstract void draw(Graphics g);

    public abstract void increase(int x, int y);
}
