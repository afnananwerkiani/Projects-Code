import java.util.*;

public class MyGraph {
    Vertex[] adjList;
    int count;

    MyGraph(int s) {
        adjList = new Vertex[s];
        count = 0;
    }

    public void addVertex(String n, int a) {
        adjList[count++] = new Vertex(n, a);
    }

    public void addEdge(String n1, String n2) {
        Vertex v1 = findVertex(n1);
        Vertex v2 = findVertex(n2);
        if (v1 != null && v2 != null) {
            v1.friendsList.add(v2);
            v2.friendsList.add(v1);
        }
    }

    public void deleteVertex(String n) {
        Vertex v = findVertex(n);
        if (v != null) {
            for (Vertex vertex : adjList) {
                if (vertex != null && vertex.friendsList.contains(v)) {
                    vertex.friendsList.remove(v);
                }
            }
        }
    }

    public void deleteEdge(String n1, String n2) {
        Vertex v1 = findVertex(n1);
        Vertex v2 = findVertex(n2);
        if (v1 != null && v2 != null) {
            v1.friendsList.remove(v2);
            v2.friendsList.remove(v1);
        }
    }

    public Vertex findVertex(String n) {
        for (Vertex vertex : adjList) {
            if (vertex != null && vertex.name.equals(n)) {
                return vertex;
            }
        }
        return null;
    }

    public void DFS() {
        boolean[] visited = new boolean[count];
        Stack<Vertex> stack = new Stack<>();
        stack.push(adjList[0]);
        visited[0] = true;
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            System.out.println(v.name);
            for (Vertex neighbor : v.friendsList) {
                int index = Arrays.asList(adjList).indexOf(neighbor);
                if (!visited[index]) {
                    stack.push(neighbor);
                    visited[index] = true;
                }
            }
        }
    }

    public LinkedList<Vertex> findPath(String source, String destination) {
        Vertex sourceVertex = findVertex(source);
        Vertex destVertex = findVertex(destination);
        if (sourceVertex == null || destVertex == null) {
            return null;
        }
        LinkedList<Vertex> path = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        if (findPathDFS(sourceVertex, destVertex, visited, path)) {
            return path;
        } else {
            return null;
        }
    }

    private boolean findPathDFS(Vertex current, Vertex destination, Set<Vertex> visited, LinkedList<Vertex> path) {
        visited.add(current);
        path.add(current);
        if (current == destination) {
            return true;
        }
        for (Vertex neighbor : current.friendsList) {
            if (!visited.contains(neighbor)) {
                if (findPathDFS(neighbor, destination, visited, path)) {
                    return true;
                }
            }
        }
        path.removeLast();
        return false;
    }

    public List<List<Vertex>> component() {
        boolean[] visited = new boolean[count];
        List<List<Vertex>> components = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (!visited[i]) {
                List<Vertex> component = new ArrayList<>();
                componentDFS(adjList[i], visited, component);
                components.add(component);
            }
        }
        return components;
    }

    private void componentDFS(Vertex current, boolean[] visited, List<Vertex> component) {
        visited[Arrays.asList(adjList).indexOf(current)] = true;
        component.add(current);
        for (Vertex neighbor : current.friendsList) {
            int index = Arrays.asList(adjList).indexOf(neighbor);
            if (!visited[index]) {
                componentDFS(neighbor, visited, component);
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Vertex vertex : adjList) {
            if (vertex != null) {
                result.append(vertex.name).append(" (").append(vertex.age).append("): ");
                for (Vertex friend : vertex.friendsList) {
                    result.append(friend.name).append(", ");
                }
                result.delete(result.length() - 2, result.length());
                result.append("\n");
            }
        }
        return result.toString();
    }
}