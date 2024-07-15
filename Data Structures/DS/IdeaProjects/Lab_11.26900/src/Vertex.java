import java.util.*;

class Vertex {
    String name;
    int age;
    LinkedList<Vertex> friendsList;

    Vertex(String d, int a) {
        name = d;
        age = a;
        friendsList = new LinkedList<>();
    }
}
