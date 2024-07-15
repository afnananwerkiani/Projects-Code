import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class Board extends JPanel implements ActionListener , MouseInputListener{

    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 800;
    private final int DELAY = 0;
    private Timer timer;
    private boolean start_drawing;
    private EditButton editButton;
    private File_Button fileButton;
    private Toolbar toolbar;
    private  Button r_tri;
    private  Button eq_tri;
    private  Button circle;
    private  Button rectangle;
    private  Button pentagram;
    private  Button hexagon;
    private Button current_shape;
    private final ArrayList<Button> shapes_buttons = new ArrayList<>();
    private Layers layers;
    private Layer top;
    private Grid grid;
    private Button back_panel;
    private final ArrayList<Tooltip> tooltips = new ArrayList<>();
    private Shapes selected_shape;
    private int x_int;
    private int y_int;
    private int x_fin;
    private int y_fin;
    private Color st_col;
    private Color but_col;
    private int stroke;
    private Stroke_Button stroke_button;
    private Button free_draw;
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            toolbar.gradientKey(e.getKeyChar());
            fileButton.Key(e.getKeyChar());
            if(editButton.Key(e.getKeyChar()) == 1)
            {
                top.undo();
            }
            else if(editButton.Key(e.getKeyChar()) == 2)
            {
                top.redo();
            }
            layers.Key(e.getKeyChar());
        }
    }

    public Board() {

        initBoard();
    }

    private void InitializeAssets() {
        back_panel = new Button(0, 0, 800, 200, Color.BLACK, Color.GRAY);
        toolbar = new Toolbar();
        layers = new Layers();
        editButton = new EditButton(64,0,64,64,layers);
        fileButton = new File_Button(0,0,64,64,layers.getLayers());
        top = layers.getTopLayer();
        grid = new Grid();
        stroke_button = new Stroke_Button(192,0,64,64);
        free_draw = new Button(256,0,64,64,Color.BLACK,Color.WHITE,"Free Draw");
        shapes_buttons.add(free_draw);


        ImageIcon c_dep = new ImageIcon("src/Shapes/Circle Dep.png");
        ImageIcon c_pre = new ImageIcon("src/Shapes/Circle Pressed.png");
        circle = new Button(100, 100, 64, 64, c_dep.getImage(), c_pre.getImage());
        shapes_buttons.add(circle);
        tooltips.add( new Tooltip(circle,"Circle"));


        ImageIcon eq_dep = new ImageIcon("src/Shapes/EQ Tri Dep.png");
        ImageIcon eq_pre = new ImageIcon("src/Shapes/EQ Tri Pre.png");
        eq_tri = new Button(200, 100, 64, 64, eq_dep.getImage(), eq_pre.getImage());
        shapes_buttons.add(eq_tri);
        tooltips.add(new Tooltip(eq_tri,"EQ Tri"));


        ImageIcon hex_dep = new ImageIcon("src/Shapes/Hex Dep.png");
        ImageIcon hex_pre = new ImageIcon("src/Shapes/Hex Pre.png");
        hexagon = new Button(300, 100, 64, 64, hex_dep.getImage(), hex_pre.getImage());
        shapes_buttons.add(hexagon);
        tooltips.add(new Tooltip(hexagon, "Hexagon"));


        ImageIcon pent_pre = new ImageIcon("src/Shapes/Pent Pre.png");
        ImageIcon pent_dep = new ImageIcon("src/Shapes/Pentagram Dep.png");
        pentagram = new Button(400, 100, 64, 64, pent_dep.getImage(), pent_pre.getImage());
        shapes_buttons.add(pentagram);
        tooltips.add(new Tooltip(pentagram, "Pentagram"));


        ImageIcon rect_dep = new ImageIcon("src/Shapes/Rectangle Dep.png");
        ImageIcon rect_pre = new ImageIcon("src/Shapes/Rectangle Pressed.png");
        rectangle = new Button(500, 100, 64, 64, rect_dep.getImage(), rect_pre.getImage());
        shapes_buttons.add(rectangle);
        tooltips.add(new Tooltip(rectangle,"Rectangle"));


        ImageIcon r_dep = new ImageIcon("src/Shapes/Right Tri Dep.png");
        ImageIcon r_pre = new ImageIcon("src/Shapes/Right Tri Pre.png");
        r_tri = new Button(600, 100, 64, 64, r_dep.getImage(), r_pre.getImage());
        shapes_buttons.add(r_tri);
        tooltips.add(new Tooltip(r_tri,"Right Tri"));

    }

    private void initBoard() {

    	addMouseListener( this );
    	addMouseMotionListener( this );
    	addKeyListener(new TAdapter());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true);

        InitializeAssets();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        layers.draw(g);
//        if(start_drawing && current_shape == rectangle)
//        {
//            selected_shape = new Rectangle(x_int,y_int,x_fin,y_fin,st_col,but_col,stroke);
//            selected_shape.draw(g);
//        }
//        else if (start_drawing && current_shape == circle)
//        {
//            selected_shape = new Circle(x_int,y_int,getRadius(),but_col,st_col,stroke);
//            selected_shape.draw(g);
//        }
//        else if(start_drawing && current_shape == eq_tri)
//        {
//            selected_shape = new EQ_Tri(x_int,y_int,getRadius(),but_col,st_col,stroke);
//            selected_shape.draw(g);
//        }
//        else if(start_drawing && current_shape == r_tri)
//        {
//            selected_shape = new RightTriangle(x_int,y_int,getRadius(),but_col,st_col,stroke);
//            selected_shape.draw(g);
//        }
//        else if(start_drawing && current_shape == hexagon)
//        {
//            selected_shape = new RegularHexagon(x_int,y_int,getRadius(),but_col,st_col,stroke);
//            selected_shape.draw(g);
//        }
//        else if(start_drawing && current_shape == pentagram)
//        {
//            selected_shape = new RegularPentagram(x_int,y_int,getRadius(),but_col,st_col,stroke);
//            selected_shape.draw(g);
//        }
//        else if(start_drawing && current_shape == free_draw)
//        {
//            selected_shape.draw(g);
//        }
//        else if(current_shape == null)
//        {
//            selected_shape = null;
//        }
        drawButton(g);

    }
    
    private void drawNotification(String text, Graphics g)
    {
    }

    private void drawButton(Graphics g) {
        back_panel.paint(g);
        layers.paint(g);
        for(Button b : shapes_buttons){
            if(b.isImg()) {
                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
            else
            {
                b.paint(g);
            }
        }
        grid.paint(g);
        fileButton.paint(g);
        editButton.paint(g);
        stroke_button.paint(g);
        toolbar.paint(g);
        if(!fileButton.getClicked() && !editButton.getClicked() && !toolbar.winClicked())
        {
            for (Tooltip t : tooltips) {
                t.paint(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().sync();
        repaint();
        top = layers.getTopLayer();
        st_col = toolbar.getStrokeColor();
        but_col = toolbar.getButtonColor();
        if(fileButton != null)
        {

        }
    }
    
    public void IsClicked(int x, int y)
    {
        if(!fileButton.getClicked() && !toolbar.winClicked()){
            editButton.handleClick(x,y);
        }
    	if(!editButton.getClicked() && !toolbar.winClicked()){
            fileButton.handleClick(x,y);
            if(fileButton.getOpen())
            {
                layers.setLayers(fileButton.getLayers());
            }
            else if (fileButton.getNewFile())
            {
                layers = fileButton.newFile();
            }
        }
        if(!fileButton.getClicked() && !editButton.getClicked()){
            toolbar.handleClick(x,y);
        }
        if(!fileButton.getClicked() && !editButton.getClicked() && !toolbar.winClicked()){
            if(stroke_button.Clicked(x,y))
            {
                stroke_button.setStroke();
                stroke = stroke_button.getStroke();
            }
            grid.handleClick(x,y);
            layers.handleClick(x,y);
            if(current_shape == null){
                for(Button b : shapes_buttons){
                    b.Toggle(x,y);
                    if (b.getClicked()){
                        current_shape = b;
                        break;
                    }
                }
            }
            else if (current_shape != null && current_shape.getClicked()) {
                current_shape.Toggle(x,y);
                selected_shape = null;
            }
            else if (current_shape != null){
                for(Button b : shapes_buttons){
                    b.Toggle(x,y);
                    if (b.getClicked()){
                        current_shape = b;
                        break;
                    }
                }
            }
        }
    }
    

	@Override
	public void mouseClicked(MouseEvent e)
    {
		IsClicked(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e)
    {
        if(!fileButton.getClicked() && !editButton.getClicked() && !toolbar.winClicked() && !start_drawing && inCanvas(e.getX(),e.getY()) && current_shape != free_draw)
        {
            start_drawing = true;
            x_int = e.getX();
            y_int = e.getY();
        }
        else if(!fileButton.getClicked() && !editButton.getClicked() && !toolbar.winClicked() && !start_drawing && inCanvas(e.getX(),e.getY()) && current_shape == free_draw)
        {
            start_drawing = true;
            x_int = e.getX();
            y_int = e.getY();
            selected_shape = new Free_Draw(stroke,but_col);
        }
	}

	@Override
	public void mouseReleased(MouseEvent e)
    {
        if(selected_shape != null ) {
            top.add(selected_shape);
            start_drawing = false;
            x_int = y_int = x_fin = y_fin = 0;
        }
	}

	@Override
	public void mouseEntered(MouseEvent e)
    {

		
	}

	@Override
	public void mouseExited(MouseEvent e)
    {

	}

	@Override
	public void mouseDragged(MouseEvent e)
    {
        if(current_shape == free_draw && inCanvas(e.getX(),e.getY()))
        {
            selected_shape.increase(e.getX(),e.getY());
        }
        else if (inCanvas(e.getX(),e.getY()) && current_shape != free_draw)
        {
            x_fin = e.getX() - x_int;
            y_fin = e.getY() - y_int;
        }

	}

	@Override
	public void mouseMoved(MouseEvent e)
    {
        toolbar.handleHover(e.getX(),e.getY());
        for(Button b:shapes_buttons)
        {
            b.Hovered(e.getX(),e.getY());
        }
	}

    private boolean inCanvas(int x, int y)
    {
        if(x > 0 && x < 600 && y > 200 && y < 800)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private int getRadius()
    {
        return (int) Math.sqrt((x_fin*x_fin)+(y_fin*y_fin));
    }
}