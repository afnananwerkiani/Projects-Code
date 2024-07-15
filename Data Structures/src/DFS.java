public class DFS
{
    public boolean searchPath(int[][] maze, int x , int y, ArrayList<Integer> path)
    {
        if (maze[y][x] == 9)
        {
            path.add(x);
            path.add(y);
            return true;
        }
        else if (maze[y][x] == 0)
        {
            maze[y][x] = 2;


            if (searchPath(maze, x + 1, y, path))
            {
                path.add(x);
                path.add(y);
                return true;
            }

            if (searchPath(maze, x - 1, y, path))
            {
                path.add(x);
                path.add(y);
                return true;
            }


            if (searchPath(maze, x, y - 1, path))
            {
                path.add(x);
                path.add(y);
                return true;
            }

            if (searchPath(maze, x, y + 1, path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}
