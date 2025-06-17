import java.util.*;

public class MyGraph {
    private Map<Integer, List<Integer>> adjList;
    private boolean isDirected;

    // Constructor
    public MyGraph(boolean isDirected) {
        this.adjList = new HashMap<>();
        this.isDirected = isDirected;
    }

    // Add a vertex
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge
    public void addEdge(int from, int to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(to);

        if (!isDirected) {
            adjList.get(to).add(from);
        }
    }

    // Remove an edge
    public void removeEdge(int from, int to) {
        List<Integer> fromNeighbors = adjList.get(from);
        List<Integer> toNeighbors = adjList.get(to);

        if (fromNeighbors != null) fromNeighbors.remove((Integer) to);
        if (!isDirected && toNeighbors != null) toNeighbors.remove((Integer) from);
    }

    // Remove a vertex
    public void removeVertex(int vertex) {
        adjList.remove(vertex);
        for (List<Integer> neighbors : adjList.values()) {
            neighbors.remove((Integer) vertex);
        }
    }

    // Print the graph
    public void printGraph() {
        for (int vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            System.out.println(adjList.get(vertex));
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Is the graph directed? (true/false): ");
        boolean directed = sc.nextBoolean();
        MyGraph graph = new MyGraph(directed);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Remove Edge");
            System.out.println("4. Remove Vertex");
            System.out.println("5. Print Graph");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter vertex: ");
                    graph.addVertex(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter from and to vertex: ");
                    graph.addEdge(sc.nextInt(), sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter from and to vertex to remove edge: ");
                    graph.removeEdge(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter vertex to remove: ");
                    graph.removeVertex(sc.nextInt());
                    break;
                case 5:
                    graph.printGraph();
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
