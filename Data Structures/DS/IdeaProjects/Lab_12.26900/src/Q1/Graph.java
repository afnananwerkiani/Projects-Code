package Q1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private ArrayList<LinkedList<Vertex>> adjacencyList;

    public Graph(int vertices) {
        adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination) {
        Vertex sourceVertex = new Vertex(source);
        Vertex destinationVertex = new Vertex(destination);
        adjacencyList.get(source).add(destinationVertex);
        adjacencyList.get(destination).add(sourceVertex);
    }

    public void BFS() {
        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex startVertex = getStartVertex();
        startVertex.visited = true;
        queue.add(startVertex);
        System.out.print(" " + startVertex.label);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            LinkedList<Vertex> neighbors = adjacencyList.get(currentVertex.label);

            for (Vertex neighbor : neighbors) {
                if (!neighbor.visited) {
                    queue.add(neighbor);
                    neighbor.visited = true;
                    System.out.print(" " + neighbor.label);
                }
            }
        }
    }
    private Vertex getStartVertex() {
        return adjacencyList.get(0).get(0);
    }
}

