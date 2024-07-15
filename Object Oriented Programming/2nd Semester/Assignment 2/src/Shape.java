import java.awt.*;
import java.awt.Point;
public abstract class Shape {
    protected Point coordinate1;
    protected Point coordinate2;
    protected Color shape_color;
    protected String text;
    private int size;

    public Shape(int side, Point location, Point location2, Color c) {
        this.size=side;
        this.coordinate1=location;
        this.coordinate2=location2;
        this.shape_color=c;
    }
    void setSize(int iSize) {
        size = Math.max(iSize, 1);
    }
    void setLocation(Point Pcenter) {
        coordinate1 = Pcenter;
    }
    void setColor(Color Ccolor) {
        shape_color = Ccolor;
    }
    public int getSize()
    {
        return size;
    }
    Point getCenter()
    {
        return coordinate1;
    }
    Color getColor()
    {
        return shape_color;
    }
    public Shape(Point a, Point b, Color buttonColor, String text) {//rectangle
        coordinate1 = new Point(a.x,a.y);
        coordinate2 = new Point(b.x,b.y);
        size= (int) Math.sqrt(Math.pow(coordinate1.x-coordinate2.x, 2)+(coordinate1.y-coordinate2.y));
        this.text = text;
        this.shape_color = buttonColor;
    }
    public Shape(Point a,Point b,Color c){//triangle
        coordinate1 = new Point(a.x,a.y);
        coordinate2 = new Point(b.x,b.y);
        this.shape_color =c;
    }
    public Shape(int iSize, Point location, Color C)//circle
    {
        setSize(iSize);
        setLocation(location);
        setColor(C);
    }
    public abstract String getDetail();
    public abstract void show(Graphics g,boolean clear);
}