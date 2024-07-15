import javax.swing.*;
import java.awt.*;

public class MazeSolver extends JFrame
{
    /**
     * Wall : 1
     * Path: 0
     * Visited: 2
     * Target: 9
     */
    int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 9, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    ArrayList<Integer> list;
    boolean drawPath;

    public void paint(Graphics g)
    {
        super.paint(g);
        g.translate(100,50);
        for (int row = 0 ; row  < maze.length ; row++)
        {
            for (int col = 0 ; col < maze[0].length ; col++)
            {
                Color color;
                switch (maze[row][col])
                {
                    case 1 ->
                    {
                        color = Color.BLACK;
                        break;
                    }
                    case 9 ->
                    {
                        color = Color.RED;
                        break;
                    }
                    default ->
                    {
                        color = Color.WHITE;
                    }
                }
                g.setColor(color);
                g.fillRect(30 * col,30 * row,30,30);
                g.setColor(Color.black);
                g.drawRect(30 * col,30 * row,30,30);
            }
        }

        if(drawPath)
        {
            for (int i = 0 ; i <= list.size() ; i += 2)
            {
                int x = list.get(i);
                int y = list.get(i + 1);
                g.setColor(Color.green);
                g.fillRect(x * 30, y * 30, 30, 30);
            }
        }
    }

    public MazeSolver()
    {
        drawPath = true;
        setTitle("Maze");
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DFS dfs = new DFS();
        list = new ArrayList<>();
        dfs.searchPath(maze,1,1,list);
        setVisible(true);
    }
}
