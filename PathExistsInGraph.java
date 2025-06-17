import java.util.*;

public class PathExistsInGraph {
    private Map<String, List<String>> adjList;

    public PathExistsInGraph() {
        adjList = new HashMap<>();
    }

    // Add edge to the graph (undirected)
    public void addEdge(String from, String to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(to);
        adjList.get(to).add(from); // Remove for directed graph
    }

    // DFS to check if path exists
    public boolean hasPath(String source, String destination) {
        Set<String> visited = new HashSet<>();
        return dfs(source, destination, visited);
    }

    // Recursive DFS helper
    private boolean dfs(String current, String destination, Set<String> visited) {
        if (current.equals(destination)) return true;

        visited.add(current);

        for (String neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, destination, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Print the graph
    public void printGraph() {
        System.out.println("\nGraph (Adjacency List):");
        for (String vertex : adjList.keySet()) {
            System.out.println(vertex + " -> " + adjList.get(vertex));
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PathExistsInGraph graph = new PathExistsInGraph();

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();
        sc.nextLine();

        Set<String> vertices = new HashSet<>();
        System.out.println("Enter vertex names:");
        for (int i = 0; i < v; i++) {
            vertices.add(sc.nextLine());
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

        System.out.print("\nEnter source node: ");
        String source = sc.next();

        System.out.print("Enter destination node: ");
        String destination = sc.next();

        if (graph.hasPath(source, destination)) {
            System.out.println("✅ A path exists between " + source + " and " + destination);
        } else {
            System.out.println("❌ No path exists between " + source + " and " + destination);
        }

        sc.close();
    }
}
