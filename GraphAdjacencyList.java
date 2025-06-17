import java.util.*;

public class GraphAdjacencyList {
    private Map<String, List<String>> adjList;

    // Constructor
    public GraphAdjacencyList() {
        adjList = new HashMap<>();
    }

    // Method to add a vertex
    public void addVertex(String vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Method to add an edge (undirected)
    public void addEdge(String from, String to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());

        adjList.get(from).add(to);
        adjList.get(to).add(from); // Remove this line for directed graph
    }

    // Method to print the graph
    public void printGraph() {
        System.out.println("Graph (Adjacency List):");
        for (String vertex : adjList.keySet()) {
            System.out.println(vertex + " -> " + adjList.get(vertex));
        }
    }

    // Main method to take input from user
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GraphAdjacencyList graph = new GraphAdjacencyList();

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.println("Enter vertex names:");
        for (int i = 0; i < v; i++) {
            String vertex = sc.nextLine();
            graph.addVertex(vertex);
        }

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter edges (format: from to):");
        for (int i = 0; i < e; i++) {
            String from = sc.next();
            String to = sc.next();
            graph.addEdge(from, to);
        }

        graph.printGraph();

        sc.close();
    }
}
