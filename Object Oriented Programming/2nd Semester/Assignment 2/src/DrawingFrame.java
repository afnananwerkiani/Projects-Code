import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

class DrawingFrame extends JFrame implements ActionListener
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame( "Drawing Program" );
        frame.setDefaultCloseOperation(3);
        DrawingPanel panel = new DrawingPanel();
        frame.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {
                try {
                    FileReader file = new FileReader("Data.txt");
                    String x = "";
                    Scanner fileRead = new Scanner(file);
                    while (fileRead.hasNextLine()) {
                        String shapeDetails = fileRead.nextLine();
                        String[] shapefile = shapeDetails.split(":");
                        if (shapefile.length == 8) {
                            Point point1 = new Point(Integer.parseInt(shapefile[1]), Integer.parseInt(shapefile[2]));
                            Point point2 = new Point(Integer.parseInt(shapefile[3]), Integer.parseInt(shapefile[4]));
                            Point point3 = new Point(Integer.parseInt(shapefile[5]), Integer.parseInt(shapefile[6]));
                            int c = Integer.parseInt(shapefile[7]);
                            Shape t = new Triangle(point1, point2, new Color(c, 0, 0), point3);
                            panel.shapeStack.push(t);
                        }
                        if (shapefile.length == 9) {
                            Point point1 = new Point(Integer.parseInt(shapefile[1]), Integer.parseInt(shapefile[2]));
                            Point point2 = new Point(Integer.parseInt(shapefile[3]), Integer.parseInt(shapefile[4]));
                            int color1 = Integer.parseInt(shapefile[5]);
                            int color2 = Integer.parseInt(shapefile[6]);
                            int color3 = Integer.parseInt(shapefile[7]);
                            int side = Integer.parseInt(shapefile[8]);
                            Shape r = new Rectangle(side, point1, point2, new Color(color1, color2, color3));
                            panel.shapeStack.push(r);
                        }
                        if (shapefile.length == 7) {
                            Point point1 = new Point(Integer.parseInt(shapefile[1]), Integer.parseInt(shapefile[2]));
                            int color1 = Integer.parseInt(shapefile[3]);
                            int color2 = Integer.parseInt(shapefile[4]);
                            int color3 = Integer.parseInt(shapefile[5]);
                            int size = Integer.parseInt(shapefile[6]);
                            Shape c = new Circle(size, point1, new Color(color1, color2, color3));
                            panel.shapeStack.push(c);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }

            public void windowClosing (WindowEvent e) {
                FileWriter file = null;
                try {
                    file = new FileWriter("C:\\Users\\afnan\\IdeaProjects\\Assignment2.26900\\src\\Data");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                PrintWriter f = new PrintWriter(file);
                for (int i = 0; i < panel.shapeStack.size(); i++) {
                    Shape a = panel.shapeStack.getShape(i);
                    f.println(a.getDetail());
                }
                f.close();
            }
            public void windowClosed(WindowEvent e) {

            }
            public void windowIconified(WindowEvent e) {

            }
            public void windowDeiconified(WindowEvent e) {

            }

            public void windowActivated(WindowEvent e) {

            }

            public void windowDeactivated(WindowEvent e) {

            }
        });
        frame.add( panel );
        frame.pack();
        frame.setVisible( true );

    }
    public void actionPerformed(ActionEvent e) {

    }
}