public class LinkedList<T>
{
    Node head;

    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * O(n)
     * @param data data to be inserted
     */
    public void insert(int data)
    {
        Node node = new Node(data);
        if(isEmpty())
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    /**
     *
     * @param data
     */
    public void remove(int data)
    {
        if(isEmpty())
        {
            return;
        }
        else
        {
            if(head.data == data)
            {
                head = head.next;
            }
            else
            {
                Node prev = null;
                Node curr = head;
                while (curr.data != data && curr != null)
                {
                    prev = curr;
                    curr = curr.next;
                }
                if (curr == null)
                {
                    System.out.println("Data Does Not Exist In The List");
                }
                else
                {
                    prev.next = curr.next;
                }
            }
        }
    }

    public String toString()
    {
        String str = "";
        Node temp = head;
        while (temp != null)
        {
            str += temp.data + " ";
            temp = temp.next;
        }
        return str;
    }

    public boolean search(int data){
        if(isEmpty())
        {
            return false;
        }
        else
        {
            Node temp = head;
            while(temp !=null )
            {
                if(temp.data == data)
                {
                    break;
                }
                temp = temp.next;
            }
            return temp != null;
        }
    }
}
