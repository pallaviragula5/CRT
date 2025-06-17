import java.util.*;

public class AdjacencyListGraph {
    private Map<Integer, List<Integer>> adjList;

    // Constructor to initialize graph
    public AdjacencyListGraph() {
        adjList = new HashMap<>();
    }

    // Method to add an edge (undirected)
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());

        adjList.get(u).add(v);
        adjList.get(v).add(u); // Comment this line for directed graph
    }

    // Method to print the graph
    public void printGraph() {
        System.out.println("Adjacency List Representation of the Graph:");
        for (int vertex : adjList.keySet()) {
            System.out.println(vertex + " -> " + adjList.get(vertex));
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdjacencyListGraph graph = new AdjacencyListGraph();

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges (format: u v):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v1 = sc.nextInt();
            graph.addEdge(u, v1);
        }

        graph.printGraph();
        sc.close();
    }
}
