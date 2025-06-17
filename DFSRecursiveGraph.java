import java.util.*;

public class DFSRecursiveGraph {
    private Map<String, List<String>> adjList;

    public DFSRecursiveGraph() {
        adjList = new HashMap<>();
    }

    // Add edge to graph (undirected)
    public void addEdge(String from, String to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());
        adjList.get(from).add(to);
        adjList.get(to).add(from); // remove this line for directed graph
    }

    // Recursive DFS helper
    private void dfsUtil(String current, Set<String> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (String neighbor : adjList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // DFS traversal
    public void dfs(String start) {
        Set<String> visited = new HashSet<>();
        System.out.print("DFS Traversal: ");
        dfsUtil(start, visited);
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
        DFSRecursiveGraph graph = new DFSRecursiveGraph();

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

        System.out.print("\nEnter starting vertex for DFS: ");
        String start = sc.next();
        if (vertices.contains(start)) {
            graph.dfs(start);
        } else {
            System.out.println("Start vertex not found.");
        }

        sc.close();
    }
}
