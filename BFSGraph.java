import java.util.*;

public class BFSGraph {
    private Map<String, List<String>> adjList;

    // Constructor
    public BFSGraph() {
        adjList = new HashMap<>();
    }

    // Add edge (undirected)
    public void addEdge(String from, String to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(to);
        adjList.get(to).add(from); // remove for directed graph
    }

    // BFS traversal
    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Print graph
    public void printGraph() {
        System.out.println("\nGraph (Adjacency List):");
        for (String vertex : adjList.keySet()) {
            System.out.println(vertex + " -> " + adjList.get(vertex));
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BFSGraph graph = new BFSGraph();

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();
        sc.nextLine();

        Set<String> vertices = new HashSet<>();
        System.out.println("Enter vertex names:");
        for (int i = 0; i < v; i++) {
            String name = sc.nextLine();
            vertices.add(name);
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

        System.out.print("\nEnter starting vertex for BFS: ");
        String start = sc.next();
        if (vertices.contains(start)) {
            graph.bfs(start);
        } else {
            System.out.println("Start vertex not found.");
        }

        sc.close();
    }
}
