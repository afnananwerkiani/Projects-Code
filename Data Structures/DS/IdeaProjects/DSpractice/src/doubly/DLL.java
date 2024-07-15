package doubly;

public class DLL<T> {
    Node<T> head;

    public boolean isEmpty() {
        return (head == null);
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void delete(T data)
    {
        if (isEmpty())
        {
            System.out.println("Phelay add something");
        }
        else
        {
            Node<T> temp = head;
            while (temp != null && temp.data != data)
            {
                temp = temp.next;
            }
            if (temp != null)
            {
                if(temp == head)
                {
                    head = head.next;
                    head.prev = null;
                }
                else if (temp.next == null)
                {
                    temp.prev.next = null;
                }
                else
                {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
            }
        }
    }
}
