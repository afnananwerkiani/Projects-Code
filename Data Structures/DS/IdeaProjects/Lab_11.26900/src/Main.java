import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyGraph graph = new MyGraph(5);
        graph.addVertex("Ali Uzzama", 69);
        graph.addVertex("Bobby", 21);
        graph.addVertex("Tarzan", 18);
        graph.addVertex("Hozan", 20);
        graph.addVertex("Malhar", 29);
        graph.addEdge("Ali Uzzama", "Bobby");
        graph.addEdge("Hozan", "Malhar");
        graph.addEdge("Bobby", "Tarzan");
        graph.addEdge("Malhar", "Ali Uzzama");
        graph.addEdge("Tarzan", "Hozan");
        System.out.println("DFS Traversal:");
        graph.DFS();
        System.out.println("\nPath from Ali Uzzama to Malhar:");
        LinkedList<Vertex> path = graph.findPath("Ali Uzzama", "Malhar");
        if (path != null) {
            for (Vertex vertex : path) {
                System.out.print(vertex.name + " ");
            }
        } else {
            System.out.println("No path found.");
        }
        System.out.println("\nConnected Components:");
        List<List<Vertex>> components = graph.component();
        for (List<Vertex> component : components) {
            for (Vertex vertex : component) {
                System.out.print(vertex.name + " ");
            }
            System.out.println();
        }
        System.out.println("\nGraph Representation:");
        System.out.println(graph.toString());
    }
}
