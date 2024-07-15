package Paint;

import java.awt.*;

public class Cell
{
    protected Point top_left = new Point();
    protected int width;
    protected int height;
    protected int stroke;
    public Color cell_color;
    public Color stroke_color;
    protected String text = "";
    public Font font;
    protected int font_size;
    protected int font_style;

    public Cell(int x,int y, int width, int height, int stroke, Color cell_color, Color stroke_color, String text)
    {
        this.top_left = new Point(x,y);
        this.width = width;
        this.height = height;
        this.stroke = stroke;
        this.cell_color = cell_color;
        this.stroke_color = stroke_color;
        this.text = text;
        this.font_size = (width*height)/250;
    }
    public void paintNormal(Graphics g)
    {
        font = new Font(text,font_style,font_size);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);
        g.setColor(stroke_color);
        g.fillRect(top_left.x-stroke, top_left.y-stroke,width+stroke*2,height+stroke*2);
        g.setColor(cell_color);
        g.fillRect(top_left.x, top_left.y,width,height);
        int string_mid_w = metrics.stringWidth(text);
        int string_mid_h = metrics.getAscent()-metrics.getAscent();
        g.setColor(Color.BLACK);
        g.drawString(text,top_left.x+width/2-string_mid_w/2,top_left.y+(height/2)+string_mid_h/2);
    }
    public void paintHighlighted(Graphics g)
    {
        font_size=width/height+10;
        g.setColor(stroke_color);
        g.fillRect(top_left.x - stroke,top_left.y - stroke,width + stroke * 2,height + stroke * 2);
        g.setColor(cell_color);
        g.fillRect(top_left.x , top_left.y , width , height);
        g.setColor(Color.WHITE);
        font = new Font(text , font_style , font_size);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics();
        int String_h = metrics.getAscent() - metrics.getDescent();
        g.drawString(this.text, top_left.x + 5, top_left.y + height/2 + String_h/2);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect( top_left.x+(24*(width/25)) - stroke,top_left.y+5 - stroke,height + stroke - 30,height + stroke - 30);
        g.setColor(Color.RED);
        g.fillRect(top_left.x+(24*(width/25))-stroke/2,top_left.y+5-stroke/2,height-30,height-30);
    }
}
