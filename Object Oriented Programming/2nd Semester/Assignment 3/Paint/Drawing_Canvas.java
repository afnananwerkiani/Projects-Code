package Paint;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Drawing_Canvas extends java.awt.Canvas //In order to Execute the objects,
{                                                   //the specific multiple line comment starting
    private int[] x_rectangle = new int[4];         //and ending points must be removed,
    private int[] y_rectangle = new int[4];         //while rest of the objects are commented.
    public void paint(Graphics g) {
/*        int[] x = {200, 200, 100, 100};
        int[] y = {200, 180, 120, 250};
        Quadrilateral quadrilateral = new Quadrilateral(x,y);
        quadrilateral.paint(g);       */                                              //Quadrilateral
/*        int[] x2 = {100, 50, 120};
          int[] y2 = {100, 80, 120};
          Triangle triangle = new Triangle(x2,y2);
          triangle.paint(g);                                                    */ //Triangle
/*        int[] x3 = {400, 200, 200, 300, 400};
          int[] y3 = {400, 400, 200, 100, 200};
          Pentagon pentagon = new Pentagon(x3,y3);
          pentagon.paint(g);                                                    */ //Pentagon
/*        int[] x4 = {100, 100, 150, 200, 200, 150};
          int[] y4 = {100, 200, 250, 200, 100, 50};
          Hexagon hexagon = new Hexagon(x4,y4);
          hexagon.paint(g);                                                     */ //Hexagon
//          Regular_Pentagon Rpentagon = new Regular_Pentagon(400,400,200);
//          Rpentagon.paintComponent(g);                                           //Regular Pentagon
/*        Regular_Hexagon Rhexagon = new Regular_Hexagon(400, 400,100);
          Rhexagon.paintComponent(g);                                           */ //Regular hexagon
        Pentagram pentagram = new Pentagram(400, 400, 100);
          Pentagram.paintComponent(g);                                           //Pentagram
    }
}
