public class Main
{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(12);
        System.out.println(list);
        list.remove(12);
        System.out.println(list);
        System.out.println(list.search(10));
    }
}