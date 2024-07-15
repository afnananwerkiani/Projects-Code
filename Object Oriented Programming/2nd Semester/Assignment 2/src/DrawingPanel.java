import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
public class  DrawingPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
    private static final long serialVersionUID = 1L;
    final int DEFAULT_WIDTH = 600;
    final int DEFAULT_HEIGHT = 600;
    private int x1, y1;
    private int x3;
    private int counter = 0;
    private int y3;
    private Point bottom;
    private Point top;
    private int x2;
    private int y2;
    private Graphics g;
    private int keyPressed;
    private Random random = new Random();

    public void setKeyPressed(int i){
        keyPressed = i;
    }
    protected ShapeStack shapeStack = new ShapeStack();
    public DrawingPanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        setFocusable(true);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setUpDrawingGraphics(false);
        if(keyPressed==1){
            Shape c = new Circle((int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)), new Point(x1, y1), new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            c.show(g, false);
        }
        if(keyPressed==2){
            Shape r = new Rectangle(((int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))), new Point(x1, y1), new Point(x2, y2), Color.darkGray);
            r.show(g, false);
        }
    }
    private void setUpDrawingGraphics(boolean clear) {
        g = getGraphics();
        System.out.println(shapeStack.size());
        if (clear == true) {
            g.setColor(Color.white);
            g.fillRect(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        } else {
            for (int i = 0; i < shapeStack.size(); i++) {
                Shape a = shapeStack.getShape(i);
                a.show(g, false);
            }
        }
    }
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        top = new Point(x, y);
    }
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e) && keyPressed == 3) {
            if (counter == 0) {
                x1 = e.getX();
                y1 = e.getY();
            } else if (counter == 1) {
                x2 = e.getX();
                y2 = e.getY();
                g.drawLine(x1,y1,x2,y2);
            } else if (counter == 2) {
                x3 = e.getX();
                y3 = e.getY();
                g.drawLine(x2,y2,x3,y3);
                Shape t = new Triangle(new Point(x1, y1), new Point(x2, y2), Color.red, new Point(x3, y3));
                t.text="Triangle";
                shapeStack.push(t);
                shapeDrawn();
                setUpDrawingGraphics(false);
                counter = -1;
            }
            counter++;
        } else {
            if (keyPressed != 3) {
                x1 = e.getX();
                y1 = e.getY();
                top = new Point(x1, y1);
            }
        }
        Queue1 shapeQueue = new Queue1();
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (keyPressed != 3) {
                x1 = e.getX();
                y1 = e.getY();
                top = new Point(x1, y1);
            }
        } else if (SwingUtilities.isRightMouseButton(e)) {

            System.out.println("Right Clicked");
            if (shapeStack.size() != 0) {
                Shape topShape = shapeStack.pop();
                shapeQueue.add(topShape);
                setUpDrawingGraphics(true);
                setUpDrawingGraphics(false);
                System.out.println("Removed " + topShape.getClass().getSimpleName());
            } else {
                System.out.println("Empty Stack now");
            }
        } else if (SwingUtilities.isMiddleMouseButton(e)) {
            System.out.println("middle pressed");
            for (int i = 0; i < shapeQueue.getSize(); i++) {
                Shape outputShape = (Shape) shapeQueue.remove();
                shapeStack.push(outputShape);

            }
            setUpDrawingGraphics(false);
        }
    }
    public void mouseReleased(MouseEvent e) {
        if (keyPressed == 1) {
            x2 = e.getX();
            y2 = e.getY();
            bottom = new Point(x2, y2);
            Shape c = new Circle((int) Math.sqrt(Math.pow(top.x - bottom.x, 2) + Math.pow(top.y - bottom.y, 2)), top, new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            shapeStack.push(c);
            c.text = "Circle";
            shapeDrawn();
            top = null;
            bottom=null;
        }
        if (keyPressed == 2) {
            x2 = e.getX();
            y2 = e.getY();
            bottom = new Point(x2, y2);
            Shape r = new Rectangle(((int) Math.sqrt(Math.pow(top.x - bottom.x, 2) + Math.pow(top.y - bottom.y, 2))), top, bottom, Color.darkGray);
            shapeStack.push(r);
            shapeDrawn();
            r.text = "Rectangle";
            bottom = null;
            top = null;
        }
        repaint();
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void mouseDragged(MouseEvent e){
        if (keyPressed != 3) {
            x2 = e.getX();
            y2 = e.getY();
        }
        repaint();
    }
    public void mouseMoved(MouseEvent e) {
        setUpDrawingGraphics(false);
    }
    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
        System.out.println("key pressed");
        if (e.getKeyChar() == '1') {
            keyPressed = 1;
        }
        if (e.getKeyChar() == '2') {
            keyPressed = 2;
        }
        if (e.getKeyChar() == '3') {
            keyPressed = 3;
        }
        shapeDrawn();
    }
    public void keyReleased(KeyEvent e) {
    }
    public void shapeDrawn() {
        g.setColor(Color.black);
        Font f = new Font("Series.BOLD",2,30);
        g.setFont(f);
        if (keyPressed == 1) {
            g.drawString("Circle", 5, DEFAULT_HEIGHT - 50);
        }
        if (keyPressed == 2) {
            g.drawString("Rectangle", 5, DEFAULT_HEIGHT - 50);
        }
        if(keyPressed==3){
            g.drawString("Triangle",5,DEFAULT_HEIGHT-50);
        }
    }
}