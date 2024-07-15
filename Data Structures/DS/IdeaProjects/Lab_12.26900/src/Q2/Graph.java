package Q2;

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

    public void shortestPath(int sourceLabel, int destinationLabel) {
        Queue<Vertex> queue = new ArrayDeque<>();
        int[] previousNode = new int[adjacencyList.size()];
        Vertex startVertex = getVertexByLabel(sourceLabel);
        startVertex.visited = true;
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            LinkedList<Vertex> neighbors = adjacencyList.get(currentVertex.label);
            for (Vertex neighbor : neighbors) {
                if (!neighbor.visited) {
                    queue.add(neighbor);
                    neighbor.visited = true;
                    previousNode[neighbor.label] = currentVertex.label;
                    if (neighbor.label == destinationLabel) {
                        queue.clear();
                        break;
                    }
                }
            }
        }
        printShortestPath(sourceLabel, destinationLabel, previousNode);
    }

    private void printShortestPath(int source, int destination, int[] previousNode) {
        System.out.print("Shortest Path from " + source + " to " + destination + ": ");
        int current = destination;
        while (current != source) {
            System.out.print(current + " ");
            current = previousNode[current];
        }
        System.out.print(source);
    }

    private Vertex getVertexByLabel(int label) {
        for (LinkedList<Vertex> vertices : adjacencyList) {
            for (Vertex vertex : vertices) {
                if (vertex.label == label) {
                    return vertex;
                }
            }
        }
        return null;
    }
}