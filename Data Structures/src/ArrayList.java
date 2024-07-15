public class ArrayList <T>
{
    int index;
    T[] list;

    public ArrayList()
    {
        index = -1;
        list = (T[]) new Object[6];
    }

    public ArrayList(int size)
    {
        index = -1;
        list = (T[]) new Object[size];
    }

    private void resize()
    {
        T[] temp = (T[]) new Object[list.length*2];
        System.arraycopy(list, 0, temp, 0, list.length);
        list = temp;
    }

    public void add(T data)
    {
        if (index == list.length - 1)
        {
            resize();
        }
        index++;
        list[index] = data;
    }

    public void remove(T data)
    {
        int location = find(data);
        if(location == -1)
        {
            System.out.println("data not in list");
        }
        else
        {
            for (int i = location ; i < list.length - 1 ; i++)
            {
                list[i] = list[i+1];
            }
            index--;
        }
    }

    public int find(T data)
    {
        for (int i = 0 ; i < list.length ; i++)
        {
            if(list[i] == data)
            {
                return i;
            }
        }
        return -1;
    }

    public int size()
    {
        return index;
    }

    public T get(int i)
    {
        if(i <= index)
        {
            return list[i];
        }
        return null;
    }

    public String toString()
    {
        String str = "( ";
        for (int i = 0 ; i < index ; i++)
        {
            str += list[i] + ",";
        }
        str += list[index] + " )";
        return str;
    }
}
