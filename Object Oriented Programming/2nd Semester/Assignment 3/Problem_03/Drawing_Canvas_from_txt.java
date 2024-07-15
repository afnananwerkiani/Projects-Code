package Problem_03;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Drawing_Canvas_from_txt extends java.awt.Canvas {
/*
    private int centre_x=0;                                               //Regular Pentagon
    private int centre_y=0;
    private int radius=0;

    public void paint(Graphics g) {
        File data = new File("C:\\Users\\afnan\\IdeaProjects\\Homework_03.26900\\src\\Problem_03\\Data");
        Scanner scanner = null;
        try {
            scanner = new Scanner(data);
            while (scanner.hasNext()) {
                String shape = scanner.next();
                if (shape.compareTo("Regular_Pentagon") == 0) {
                    centre_x = scanner.nextInt();
                    centre_y = scanner.nextInt();
                    radius = scanner.nextInt();
                    Regular_Pentagon rpenta = new Regular_Pentagon(centre_x, centre_y, radius);
                    rpenta.paint(g);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
} */

/*    private int centre_x=0;                                               //Regular Hexagon
    private int centre_y=0;
    private int radius=0;

    public void paint(Graphics g) {
        File data = new File("C:\\Users\\afnan\\IdeaProjects\\Homework_03.26900\\src\\Problem_03\\Data");
        Scanner scanner = null;
        try {
            scanner = new Scanner(data);
            while (scanner.hasNext()) {
                String shape = scanner.next();
                if (shape.compareTo("Regular_Hexagon") == 0) {
                    centre_x = scanner.nextInt();
                    centre_y = scanner.nextInt();
                    radius = scanner.nextInt();
                    Regular_Hexagon rhexagon = new Regular_Hexagon(centre_x, centre_y, radius);
                    rhexagon.paint(g);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        }
    } */

/*    private int centre_x=0;                                                 //Pentagram
    private int centre_y=0;
    private int radius = 0;
    public void paint(Graphics g) {
        File data = new File("C:\\Users\\afnan\\IdeaProjects\\Homework_03.26900\\src\\Problem_03\\Data");
        Scanner scanner = null;
        try {
            scanner = new Scanner(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }try {
            while (scanner.hasNext())
                if (scanner.next().compareTo("Pentagram") == 0) {
                    centre_x= scanner.nextInt();
                    centre_y= scanner.nextInt();
                    radius= scanner.nextInt();
                    Pentagram pentagram = new Pentagram( centre_x,centre_y, radius);
                    pentagram.paint(g);
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
} */


    private int[] x_quad = new int[4];                                       //Quadrilateral
    private int[] y_quad = new int[4];
    public void paint(Graphics g) {
        File data = new File("C:\\Users\\afnan\\IdeaProjects\\Homework_03.26900\\src\\Problem_03\\Data");
        Scanner scanner = null;
        try {
            scanner = new Scanner(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }try {
            while (scanner.hasNext())
                if (scanner.next().compareTo("Quadrilateral") == 0) {
                    for (int i = 0; i < 4; i++) {
                        x_quad[i] = scanner.nextInt();
                    }
                    for (int i = 0; i < 4; i++) {
                        y_quad[i] = scanner.nextInt();
                    }
                    Quadrilateral quad = new Quadrilateral(x_quad, y_quad);
                    quad.paint(g);
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

/*  private int[] x_pent = new int[5];                                              //Pentagon
    private int[] y_pent = new int[5];

    public void paint(Graphics g) {
        File data = new File("C:\\Users\\afnan\\IdeaProjects\\Homework_03.26900\\src\\Problem_03\\Data");
        Scanner scanner = null;
        try {
            scanner = new Scanner(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            while (scanner.hasNext())
                if (scanner.next().compareTo("Pentagon") == 0) {
                    for (int i = 0; i < 5; i++) {
                        x_pent[i] = scanner.nextInt();
                    }
                    for (int i = 0; i < 5; i++) {
                        y_pent[i] = scanner.nextInt();
                    }
                    Pentagon pent = new Pentagon(x_pent, y_pent);
                    pent.paint(g);
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
} */


/*      private int[] x_hex = new int[6];                                        //Hexagon
        private int[] y_hex = new int[6];
        public void paint(Graphics g) {
        File data = new File("C:\\Users\\afnan\\IdeaProjects\\Homework_03.26900\\src\\Problem_03\\Data");
        Scanner scanner = null;
        try {
            scanner = new Scanner(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
            while (scanner.hasNext())
                 if (scanner.next().compareTo("Hexagon") == 0) {
                     for (int i = 0; i < 6; i++) {
                         x_hex[i] = scanner.nextInt();
                     }
                     for (int i = 0; i < 6; i++) {
                         y_hex[i] = scanner.nextInt();
                     }
                     Hexagon hexagon = new Hexagon(x_hex, y_hex);
                     hexagon.paint(g);
                 }
        }
} */

/*
    private int[] x_triangle = new int[3];                                       //Triangle
    private int[] y_triangle = new int[3];

    public void paint(Graphics g) {
        File data = new File("C:\\Users\\afnan\\IdeaProjects\\Homework_03.26900\\src\\Problem_03\\Data");
        try {
            Scanner scanner = new Scanner(data);
            while (scanner.hasNext()){
               if (scanner.next().compareTo("Triangle") == 0) {
                    for (int i = 0; i < 3; i++) {
                        x_triangle[i] = scanner.nextInt();
                    }
                    for (int i = 0; i < 3; i++) {
                        y_triangle[i] = scanner.nextInt();
                    }
                    Triangle triangle = new Triangle(x_triangle, y_triangle);
                    triangle.paint(g);
                }
        }
    }
        catch (FileNotFoundException e)
    {
        throw new RuntimeException(e);
    }
}
} */