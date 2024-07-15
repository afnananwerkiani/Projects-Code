import java.awt.*;
public class Circle extends Shape{
    Circle(int iSize, Point location, Color C)
    {
        super(iSize,location,C);
    }
    public int remove1(){
        DrawingPanel p = new DrawingPanel();
        int x= p.DEFAULT_HEIGHT;
        return x;
    }
    public String getDetail(){
        return "Circle"+":"+super.coordinate1.x+":"+super.coordinate1.y+":"+shape_color.getRed()+":"+shape_color.getBlue()+":"+shape_color.getGreen()+":"+super.getSize();
    }
    public int remove2(){
        DrawingPanel p = new DrawingPanel();
        int y = p.DEFAULT_WIDTH;
        return y;
    }
    public void show(Graphics g,boolean clear)
    {
        if(clear == true){
            g.setColor(Color.black);
            g.fillRect(0, 0, remove1(), remove2());
        }
        g.setColor(getColor());
        g.fillOval(super.getCenter().x - super.getSize()/2 ,super.getCenter().y - super.getSize()/2,super.getSize(),super.getSize());
    }
}