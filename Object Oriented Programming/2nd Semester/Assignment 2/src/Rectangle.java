import java.awt.*;
public class Rectangle extends Shape {
    private int height;
    private int width;
    public Rectangle(String text, Point coordinate1, Point coordinate2, Color c) {
        super(coordinate1, coordinate2, c, text);
        height = coordinate2.x - coordinate1.x;
        width = coordinate2.y - coordinate1.y;
    }
    public String getDetail(){
        return "Rectangle"+":"+super.coordinate1.x+":"+super.coordinate1.y+":"+super.coordinate2.x+":"+super.coordinate2.y+":"+shape_color.getRed()+":"+shape_color.getBlue()+":"+shape_color.getGreen()+":"+this.getSize();
    }
    public Rectangle(int side, Point location, Point location2, Color C) {
        super(side, location,location2, C);
        this.height = side;
        this.width = location2.y - location.y;
    }
    public int remove1(){
        DrawingPanel p = new DrawingPanel();
        int x= p.DEFAULT_HEIGHT;
        return x;
    }
    public int remove2(){
        DrawingPanel p = new DrawingPanel();
        int y = p.DEFAULT_WIDTH;
        return y;
    }
    public void show(Graphics g, boolean clear) {
        if (clear == true) {
            g.fillRect(0, 0,remove1(),remove2());
        } else {
            g.setColor(Color.GRAY);
            Font f = new Font(text, 1, 3);
            g.setFont(f);
            g.fillRect(super.coordinate1.x - super.getSize() / 2, super.coordinate1.y - super.getSize() / 2, height, width);
        }
    }
}