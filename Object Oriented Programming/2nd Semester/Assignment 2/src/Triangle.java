import java.awt.*;
public class Triangle extends Shape {
    private Point thirdPoint;
    Color triangleColor =Color.red;
    public Triangle(Point p1,Point p2,Color c,Point thirdPoint){
        super(p1,p2,Color.red);
        this.thirdPoint= thirdPoint;
    }
    public Point getThirdPoint(){
        return thirdPoint;
    }
    public String getDetail(){
        return "Triangle"+":"+super.coordinate1.x+":"+super.coordinate1.y+":"+super.coordinate2.x+":"+super.coordinate2.y+":"+thirdPoint.x+":"+thirdPoint.y+":"+triangleColor.getRed();
    }
    public void show(Graphics g, boolean clear) {
        g.setColor(Color.red);
        int[] x = {super.coordinate1.x,super.coordinate2.x,thirdPoint.x};
        int[] y ={super.coordinate1.y,super.coordinate2.y,thirdPoint.y};
        g.fillPolygon(x,y,3);
    }
}