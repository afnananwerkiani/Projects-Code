import java.awt.*;
import java.util.ArrayList;

public class Toolbar extends Button{
    private final Button edit_col;
    private final Window edit_win;
    private final Button s_col;
    private final Button b_col;
    private final Button red;
    private final Button green;
    private final Button blue;
    private final Button custom1;
    private final Button custom2;
    private final Button custom3;
    private final ArrayList<Button> gradient = new ArrayList<>();
    private final Button display;
    private final ArrayList<Button> customs = new ArrayList<>();
    private final Button add_col;
    private int count = 0;
    private ArrayList<Tooltip> tooltips = new ArrayList<>();
    public Toolbar(){


        super(0,0,0,0, Color.BLACK,Color.GRAY);


        red = new Button(500, 10, 32, 32, Color.BLACK, Color.RED);


        blue = new Button(540, 10, 32, 32, Color.BLACK, Color.BLUE);


        green = new Button(580, 10, 32, 32, Color.BLACK, Color.GREEN);


        custom1 = new Button(500, 50, 32, 32, Color.BLACK, Color.white);
        customs.add(custom1);


        custom2 = new Button(540, 50, 32, 32, Color.BLACK, Color.white);
        customs.add(custom2);


        custom3 = new Button(580, 50, 32, 32, Color.BLACK, Color.WHITE);
        customs.add(custom3);


        s_col = new Button(645, 20, 64, 64, Color.BLACK, Color.WHITE);
        tooltips.add(new Tooltip(s_col,"Stroke Color"));


        b_col = new Button(720, 20, 64, 64, Color.BLACK, Color.WHITE);
        tooltips.add(new Tooltip(b_col,"Button Color"));


        edit_col = new Button(700, 100, 75, 50, Color.BLACK, Color.WHITE, "Edit Color");


        edit_win = new Window(100,250,400,400,"Gradient");


        display = new Button(174,580,66,40,Color.BLACK,Color.WHITE);


        add_col = new Button(364,580,66,40,Color.BLACK,Color.WHITE,"Add Color");
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        red.paint(g);
        blue.paint(g);
        green.paint(g);
        for(Button b : customs){
            b.paint(g);
        }
        s_col.paint(g);
        b_col.paint(g);
        edit_col.paint(g);
        if(!edit_win.getVisible())
        {
            for (Tooltip t : tooltips) {
                t.paint(g);
            }
        }
        if(edit_win.getVisible()){
            edit_win.paint(g);
            display.paint(g);
            add_col.paint(g);
            for(Button b:gradient){
                b.paint(g);
            }
        }
    }

    public void handleClick(int x, int y){
        if(!edit_win.getVisible()){
            if(edit_col.Clicked(x,y)){
                makeGradient();
                edit_win.setVisible(true);
            }
            if(!s_col.getClicked()){
                b_col.Toggle(x,y);
            }
            if (!b_col.getClicked()){
                s_col.Toggle(x,y);
            }
            if(s_col.getClicked() && red.Clicked(x,y)){
                s_col.setColor(red.getColor());
            }
            else if(s_col.getClicked() && blue.Clicked(x,y)){
                s_col.setColor(blue.getColor());
            }
            else if(s_col.getClicked() && green.Clicked(x,y)){
                s_col.setColor(green.getColor());
            }
            else if(s_col.getClicked() && custom1.Clicked(x,y)){
                s_col.setColor(custom1.getColor());
            }
            else if(s_col.getClicked() && custom2.Clicked(x,y)){
                s_col.setColor(custom2.getColor());
            }
            else if(s_col.getClicked() && custom3.Clicked(x,y)){
                s_col.setColor(custom3.getColor());
            }
            if(b_col.getClicked() && red.Clicked(x,y)){
                b_col.setColor(red.getColor());
            }
            else if(b_col.getClicked() && blue.Clicked(x,y)){
                b_col.setColor(blue.getColor());
            }
            else if(b_col.getClicked() && green.Clicked(x,y)){
                b_col.setColor(green.getColor());
            }
            else if(b_col.getClicked() && custom1.Clicked(x,y)){
                b_col.setColor(custom1.getColor());
            }
            else if(b_col.getClicked() && custom2.Clicked(x,y)){
                b_col.setColor(custom2.getColor());
            }
            else if(b_col.getClicked() && custom3.Clicked(x,y)){
                b_col.setColor(custom3.getColor());
            }
        }
        else if(edit_win.getVisible()){
            if(edit_win.Clicked(x,y)){
                edit_win.setVisible(false);
            }
            for(Button b:gradient){
                if(b.Clicked(x,y)){
                    display.setColor(b.getColor());
                }
            }
            if(add_col.Clicked(x,y)){
                if(count==customs.size()){
                    count=0;
                }
                customs.get(count).setColor(display.getColor());
                count++;
            }
        }
    }
    public void handleHover(int x, int y)
    {
        b_col.Hovered(x,y);
        s_col.Hovered(x,y);
    }

    public boolean winClicked(){
        return edit_win.getVisible();
    }

    public void makeGradient(){
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                Button b = new Button(174+j,300+i,1,1,Color.getHSBColor((256-i)/256.0f,j/256.0f,0.8f),Color.getHSBColor((256-i)/256.0f,j/256.0f,0.8f));
                gradient.add(b);
            }
        }
    }

    public void gradientKey(char key){
        if(key == 'g'){
            makeGradient();
            edit_win.setVisible(true);
        }
    }

    public Color getButtonColor()
    {
        return b_col.getColor();
    }

    public Color getStrokeColor()
    {
        return s_col.getColor();
    }
}
