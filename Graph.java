import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Add a vertex
    public void addVertex(int v) {
        adjList.putIfAbsent(v, new ArrayList<>());
    }

    // Add an edge (undirected)
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printGraph() {
        for (int v : adjList.keySet()) {
            System.out.print(v + " -> ");
            System.out.println(adjList.get(v));
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.printGraph();
    }
}
