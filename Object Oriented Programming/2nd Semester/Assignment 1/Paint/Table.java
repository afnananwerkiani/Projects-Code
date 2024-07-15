package Paint;

import java.awt.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Table
{
    public Title_Bar titleBar;
    public Cell[] headers;
    public Cell[] cells;
    private int header_count;
    private int cell_count;
    boolean file_empty = false;
    File file = new File("C:\\Users\\afnan\\IdeaProjects\\Assignment_01.26900\\text");
    public void createTable()
    {
        if(file.length()==0)
        {
            file_empty=true;
        }
        else {
            try {
                Scanner counter = new Scanner(file);
                while (counter.hasNext()) {
                    String temp = "";
                    temp = counter.next();
                    if (temp.charAt(0) == '^') {
                        titleBar = new Title_Bar(0, 0, 800, 50, 3, Color.BLACK, Color.GRAY, temp.substring(1));
                    } else if (temp.charAt(0) == '%') {
                        header_count++;
                    } else if (temp.charAt(0) != '^' && temp.charAt(0) != '%') {
                        cell_count++;
                    }
                }
            } catch (FileNotFoundException e) {

            }
            int cell_per_header = cell_count / header_count;
            int width = titleBar.width / header_count;
            headers = new Cell[header_count];
            cells = new Cell[cell_count];
            header_count = 0;
            cell_count = 0;
            try {
                Scanner reader = new Scanner(file);
                while (reader.hasNext()) {
                    String temp = "";
                    temp = reader.next();
                    if (temp.charAt(0) == '%') {
                        if (headers[0] == null) {
                            headers[header_count] = new Cell(titleBar.top_left.x, titleBar.top_left.y + titleBar.height, width, 30, 3, Color.WHITE, Color.BLUE, temp.substring(1));
                        } else {
                            headers[header_count] = new Cell(headers[header_count - 1].top_left.x + width, titleBar.top_left.y + titleBar.height, width, 30, 3, Color.WHITE, Color.BLUE, temp.substring(1));
                        }
                        header_count++;
                    }
                    if (temp.charAt(0) != '^' && temp.charAt(0) != '%') {
                        if (cells[0] == null || cell_count % cell_per_header == 0) {
                            cells[cell_count] = new Cell(headers[header_count - 1].top_left.x, headers[header_count - 1].top_left.y + headers[header_count - 1].height, width, 30, 3, Color.WHITE, Color.BLACK, temp);
                        } else {
                            cells[cell_count] = new Cell(cells[cell_count - 1].top_left.x, cells[cell_count - 1].top_left.y + cells[cell_count - 1].height, width, 30, 3, Color.WHITE, Color.BLACK, temp);
                        }
                        cell_count++;
                    }
                }
            } catch (FileNotFoundException e) {

            }
        }
    }
}