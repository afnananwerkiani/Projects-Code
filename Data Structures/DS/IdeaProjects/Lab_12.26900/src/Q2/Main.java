package Q2;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        int sourceNode = 0;
        int destinationNode = 3;
        System.out.println("Shortest Path:");
        graph.shortestPath(sourceNode, destinationNode);
    }
}
