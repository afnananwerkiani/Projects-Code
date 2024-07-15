package Paint;
import java.awt.*;
import java.io.File;

public class Drawing_Canvas extends Canvas
{
    public void paint(Graphics g)
    {
        Table table = new Table();
        table.createTable();
        if (table.file_empty)
        {
            Title_Bar titleBar=new Title_Bar(0,0,800,50, 3,Color.BLACK,Color.GRAY,"Data Table");
            titleBar.paintHighlighted(g);
            titleBar.paint(g);
            Cell Data=new Cell(0,50,100,50,3,Color.BLUE, Color.BLACK, "Default");
            int count = 0;
            for(int i =0;i<72;i++)
            {
                if(count==0)
                {
                    Data.text="Data";
                    Data.paintNormal(g);
                    count++;
                }
                else if (count%9==0)
                {
                    Data.text="Data";
                    Data.top_left.x+=Data.width;
                    Data.top_left.y= titleBar.top_left.y+ titleBar.height;
                    Data.paintNormal(g);
                    count++;
                }
                else
                {
                    Data.text="Default";
                    Data.top_left.y+= Data.height;
                    Data.paintNormal(g);
                    count++;
                }
            }
        }
        else
        {
            table.titleBar.paintHighlighted(g);
            table.titleBar.paint(g);
            for (int i = 0; i < table.headers.length; i++) {
                table.headers[i].paintNormal(g);
            }
            for (int i = 0; i < table.cells.length; i++) {
                table.cells[i].paintNormal(g);
            }
        }
    }
}