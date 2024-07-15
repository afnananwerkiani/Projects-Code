public class Queue1 {
    public Node head;
    public Node tail;
    public int size;
    public Queue1(){
        size =0;
    }
    public void add(Shape t){
        if(head==null) {
            head = new Node(t);
            tail= head;
        }
        else{
            tail.next=new Node(t);
            tail = tail.next;
        }
        size++;
    }
    public Shape remove(){
        if(size==0){
            return null;
        }
        Shape t = head.shape;
        head = head.next;
        size--;
        return t;
    }
    public int getSize() {
        return size;
    }
}